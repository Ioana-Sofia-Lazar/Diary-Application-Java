package main;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.awt.Image;
import java.awt.Toolkit;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    
    private int deleteUser(int id) {
        // delete user
        String query = "DELETE FROM user WHERE id_user = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
        
            if((st.executeUpdate()) != 1) {  
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
        
            if((st.executeUpdate()) != 1) {  
                return -1;                     
            }                             
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
        HashMap<Integer, Entry> entries = new HashMap<>();
                
        if(user != null) { // retrieve all data for this user
            s = getSettings(user.getId());
            entries = getEntries(user.getId());
            handlerResponse = new loginResponsePacket(user, s, entries);
        }
        
        return handlerResponse;
    }
    
    private HashMap<Integer, Entry> getEntries(int id) {
        HashMap<Integer, Entry> entr = new HashMap<>();
        
        String query = "SELECT * FROM entry WHERE id_user = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Entry e = new Entry(rs.getInt("id_entry"), rs.getString("title"), rs.getString("text"),
                    rs.getDate("date"));
                entr.put(e.getId(), e);
            } 
        }
        catch(Exception e) {
            System.out.println("error at getting entries");
            e.printStackTrace();
        }        
        return entr;
    }

}
