package main;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import packets.closeAppPacket;
import packets.deleteAccountPacket;
import packets.loginPacket;
import packets.loginResponsePacket;
import packets.signupPacket;

public class ServerHandler extends Thread{
    private Connection DBConnection;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ServerHandler(Socket socket) throws SQLException {
        this.socket = socket;
        // Connect to MySQL
        String url = "jdbc:mysql://localhost:3306/diary_app?useSSL=false";
        String user = "root";
        String password = "root";
        
        this.DBConnection = DriverManager.getConnection(url, user, password);
        if(DBConnection != null)
            System.out.println("connected to db successfully");       
    }

    @Override
    public void run(){
        try {
            
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Object message = in.readObject();
                             
                if(message instanceof loginPacket) {
                    loginPacket msg = (loginPacket) message;
                    loginResponsePacket handlerResponse = handleLogin(msg.getUsername(), msg.getPassword());
                    out.writeObject(handlerResponse);
                    out.flush();
                }
                if(message instanceof signupPacket) {
                    signupPacket msg = (signupPacket) message;
                    int handlerResponse = handleSignup(msg.getUsername(), msg.getPassword());
                    out.writeObject(handlerResponse);
                    out.flush();
                }
                if(message instanceof deleteAccountPacket) {
                    deleteAccountPacket msg = (deleteAccountPacket) message;
                    int handlerResponse = deleteUser(msg.getId());
                    out.writeObject(handlerResponse);
                    out.flush();
                }
                if(message instanceof closeAppPacket) {
                    closeAppPacket msg = (closeAppPacket) message;
                    closeAppHandler(msg.getENTRIES(), msg.getUSER(), msg.getSETTINGS());                    
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error on user input/output streams");
        } catch (ClassNotFoundException e){
            System.out.println("There was a problem decoding message from user");
        } finally {
            try {
                DBConnection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close MySQL connection");
            }
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket files");
            }
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket");
            }
        }
    }
    
    private void updateUser(User user) {
        int id = user.getId();
        String query = "UPDATE user SET password = ?, name = ?, birthdate = ?, profile_pic = ? WHERE id_user = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            // prepare the photo
            Image image = user.getProfilePic().getImage();
            BufferedImage bImage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
            Graphics bg = bImage.getGraphics();
            bg.drawImage(image,0,0,null);
            bg.dispose();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpeg", out);
            byte[] buf = out.toByteArray();
            ByteArrayInputStream inStream = new ByteArrayInputStream(buf);            
            
            st.setString(1, user.getPassword());
            st.setString(2, user.getName());
            st.setDate(3, user.getBirthdate());
            st.setBinaryStream(4,inStream,inStream.available());
            st.setInt(5, id);
        
            if((st.executeUpdate()) != 1) {  
                                    
            }                             
        }
        catch(Exception e) {
            System.out.println("error at updating user");
            e.printStackTrace();
        }  
        
    }
    
    private void updateSettings(Settings settings) {
        int id = settings.getId();
        String query = "UPDATE settings SET theme = ? WHERE id_setting = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, settings.getTheme());
            st.setInt(2, id);

            st.executeUpdate();
        }
        catch(Exception e) {
            System.out.println("error at deleting user");
            e.printStackTrace();
        }  
    }
    
    private void updateEntries(int id, HashMap<Date, ArrayList<Entry>> entries) {
        Iterator it = entries.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<Entry> en = (ArrayList<Entry>) pair.getValue();
            ByteArrayInputStream inStream = null; 
            for(Entry e : en) {
                // prepare the photo
                if(e.getPic() != null) {
                    try {
                        Image image = e.getPic().getImage();
                        BufferedImage bImage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
                        Graphics bg = bImage.getGraphics();
                        bg.drawImage(image,0,0,null);
                        bg.dispose();
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        ImageIO.write(bImage, "jpeg", out);
                        byte[] buf = out.toByteArray();
                        inStream = new ByteArrayInputStream(buf); 
                    } catch (IOException ex) {
                        Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                                              
                if(e.isAdded() && e.isRemoved()) { // entry was in DB and was removed by user
                    String query = "DELETE FROM entry WHERE id_user = ? AND id_entry = ?";
                    try(PreparedStatement st = DBConnection.prepareStatement(query);) {
                        st.setInt(1, id);
                        st.setInt(2, e.getId());
                        st.executeUpdate();
                    }
                    catch(Exception ex) {
                        System.out.println("error at deleting entry");
                        ex.printStackTrace();
                    }  
                }
                if(!e.isAdded() && e.getId() < 0) { // entry was not in the DB
                    System.err.println("inserting");
                    String query = "INSERT INTO entry(id_user, title, text, location, date, time, image) "
                            + "VALUES(?, ?, ?, ?, ?, ?, ?);";
                    try(PreparedStatement st = DBConnection.prepareStatement(query);) {
                        st.setInt(1, id);
                        st.setString(2, e.getTitle());
                        st.setString(3, e.getText());
                        st.setString(4, e.getLocation());
                        st.setDate(5, e.getDate());
                        st.setTime(6, e.getTime());
                        if(inStream != null)
                            st.setBinaryStream(7,inStream,inStream.available());
                        else
                            st.setString(7, null);
                        
                        st.executeUpdate();
                    }
                    catch(Exception ex) {
                        System.out.println("error at inserting entry");
                        ex.printStackTrace();
                    }  
                }
                if(!e.isAdded() && e.getId() > 0) { // entry was in the Db and was modified
                    String query = "UPDATE entry SET title = ?, text = ?, location = ?, date = ?, time = ?, image = ?" +
                            "WHERE id_entry = ? ";
                    try(PreparedStatement st = DBConnection.prepareStatement(query);) {                       
                        st.setString(1, e.getTitle());
                        st.setString(2, e.getText());
                        st.setString(3, e.getLocation());
                        st.setDate(4,e.getDate());
                        st.setTime(5, e.getTime());
                        st.setBinaryStream(6, inStream, inStream.available());
                        st.setInt(7, e.getId());

                        if((st.executeUpdate()) != 1) {  

                        }                             
                    }
                    catch(Exception ex) {
                        System.out.println("error at updating entry");
                        ex.printStackTrace();
                    }  
        
                }
            }
                        
        }
        
    }
    
    private void closeAppHandler(HashMap<Date, ArrayList<Entry>> entries, User user, Settings settings) {
        updateUser(user);
        updateSettings(settings);
        updateEntries(user.getId(), entries);
    }
    
    private int deleteUser(int id) {
        // delete user
        String query = "DELETE FROM user WHERE id_user = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
        
            if((st.executeUpdate()) != 1) {  
                System.err.println("-- deleting user");
                return -1;                     
            }                             
        }
        catch(Exception e) {
            System.out.println("error at deleting user");
            e.printStackTrace();
        }  
        
        // delete his settings
        query = "DELETE FROM settings WHERE id_user = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
        
            if((st.executeUpdate()) != 1) { 
                System.err.println("-- deleting settings");
                return -1;                     
            }                             
        }
        catch(Exception e) {
            System.out.println("error at deleting user settings");
            e.printStackTrace();
        }  
        
        // delete his entries
        query = "DELETE FROM entry WHERE id_user = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
        
            st.executeUpdate();                            
        }
        catch(Exception e) {
            System.out.println("error at deleting user entries");
            e.printStackTrace();
        }  
        
        return 1;
    }
    
    private int validateSignup(String username) {System.out.println("vaidating signup for " + username);
        String query = "SELECT * FROM user WHERE username = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()) { // there is a user with this username
                return 1;
            }    
        }
        catch(Exception e) {
            System.out.println("error at validating signup");
            e.printStackTrace();
        }
        return -1;
    }
    
    // add user to database and return the id or -1 if error
    private int addUser(String username, String password) {
        String query = "INSERT INTO user (username, password, birthdate, profile_pic) VALUES (?, ?, ?, ?);";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            File imgfile = new File("default_profile.jpg");
            FileInputStream fin = new FileInputStream(imgfile);
            st.setString(1, username);
            st.setString(2, password);
            st.setDate(3, Date.valueOf("1990-01-01"));
            st.setBinaryStream(4, (InputStream)fin, (int)imgfile.length());

            if((st.executeUpdate()) != 1) {
                return -1;    
            }              
        }
        catch(Exception e) {
            System.out.println("error at adding user");
            e.printStackTrace();
        }
        
        query = "SELECT * FROM user WHERE username = ? and password = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if(rs.next())
                return rs.getInt("id_user");                            
        }
        catch(Exception e) {
            System.out.println("error at adding user");
            e.printStackTrace();
        }
        
        return -1;
    }
    
    private int addDefaultSettings(int id) {
        String query = "INSERT INTO settings(id_user) VALUES(?);";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);

            if((st.executeUpdate()) == 1) {
                return 1;    
            }              
        }
        catch(Exception e) {
            System.out.println("error at adding user default settings");
            e.printStackTrace();
        }
        return -1;
    }
    
    // 1 for successfull adding new user, -1 if user already exists, -2 for another error
    private int handleSignup(String username, String password) {System.out.println("handle signup for " + username + " " + password);
        int found = validateSignup(username);
        if(found == 1) // if user already exists then error
            return -1;

        // add user to database
        int id = addUser(username, password);
        if(id == -1)
            return -2;

        // add default settings for new user
        int res = addDefaultSettings(id);
        if(res == -1)
            return -2;

        return 1;
    }
    
    private User validateLogin(String username, String password) {System.out.println("vaidating login for " + username);
        String query = "SELECT * FROM user WHERE username = ? AND password = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) { // there is a user with this username
                // get profile pic
                byte[] image = rs.getBytes("profile_pic");
                ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(image));
                
                return new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
                    rs.getString("name"), rs.getDate("birthdate"), icon);
            }    
        }
        catch(Exception e) {
            System.out.println("error at validating login");
            e.printStackTrace();
        }
        return null;
    }
    
    private Settings getSettings(int id) {
        String query = "SELECT * FROM settings WHERE id_user = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) { // there is a user with this username
                return new Settings(rs.getInt("id_setting"), rs.getInt("send_reminders"), rs.getInt("theme"));
            }    
        }
        catch(Exception e) {
            System.out.println("error at getting settings");
            e.printStackTrace();
        }
        return null;
    }
    
    private loginResponsePacket handleLogin(String username, String password) { System.out.println("handle login for " + username + " " + password);
        loginResponsePacket handlerResponse = new loginResponsePacket(null, null, null);
        User user = validateLogin(username, password);    
        Settings s;
        HashMap<Date, ArrayList<Entry>> entries = new HashMap<>();
                
        if(user != null) { // retrieve all data for this user
            s = getSettings(user.getId());
            entries = getEntries(user.getId());
            handlerResponse = new loginResponsePacket(user, s, entries);
        }
        
        return handlerResponse;
    }
    
    private HashMap<Date, ArrayList<Entry>> getEntries(int id) {
        HashMap<Date, ArrayList<Entry>> entr = new HashMap<>();
        
        String query = "SELECT * FROM entry WHERE id_user = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                // get image
                byte[] image = rs.getBytes("image");
                ImageIcon icon = null;
                if(image != null )
                    icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(image));
                
                Entry e = new Entry(rs.getInt("id_entry"), rs.getString("title"), rs.getString("text"),
                    rs.getDate("date"), rs.getTime("time"), icon, rs.getString("location"), true);
                if(entr.get(e.getDate()) != null) { // the date already exists in the hashmap
                    ArrayList<Entry> en = entr.get(e.getDate());
                    en.add(e);
                    entr.put(e.getDate(), en);
                }
                else {
                    ArrayList<Entry> en = new ArrayList<>();
                    en.add(e);
                    entr.put(e.getDate(), en);
                }
            } 
        }
        catch(Exception e) {
            System.out.println("error at getting entries");
            e.printStackTrace();
        }   
        return entr;
    }

}
