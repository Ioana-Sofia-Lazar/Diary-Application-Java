package main;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
                    handleLogin(msg.getUsername(), msg.getPassword());
                }
                if(message instanceof signupPacket) {
                    signupPacket msg = (signupPacket) message;
                    int handlerResponse = handleSignup(msg.getUsername(), msg.getPassword());
                    out.writeObject(handlerResponse);
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error on client input/output streams");
        } catch (ClassNotFoundException e){
            System.out.println("There was a problem decoding message from client");
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
    
    private int validateSignup(String username) {
        String query = "SELECT * FROM user WHERE username = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()) { // there is a user with this username
                return 1;
            }    
        }
        catch(Exception e) {
            System.out.println("error at validating login");
            e.printStackTrace();
        }
        return -1;
    }
    
    // add user to database and return the id or -1 if error
    private int addUser(String username, String password) {
        String query = "INSERT INTO user (username, password) VALUES (?, ?);";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, username);
            st.setString(2, password);

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
            System.out.println("error at adding user");
            e.printStackTrace();
        }
        return -1;
    }
    
    // 1 for successfull adding new user, -1 if user already exists, -2 for another error
    private int handleSignup(String username, String password) {
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
    
    private User validateLogin(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) { // there is a client with this username
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
        String query = "SELECT * FROM settings WHERE id_client = ?;";
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
    
    private void handleLogin(String username, String password) {
        loginResponsePacket handlerResponse = new loginResponsePacket(null, null, null);
        User user = validateLogin(username, password);    
        Settings s;
        HashMap<Integer, Entry> entries = new HashMap<>();
                
        if(user != null) { // retrieve all data for this user
            s = getSettings(user.getId());
            entries = getEntries(user.getId());
            handlerResponse = new loginResponsePacket(user, s, entries);
        }
        
        try {
            out.writeObject(handlerResponse);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private HashMap<Integer, Entry> getEntries(int id) {
        HashMap<Integer, Entry> entr = new HashMap<>();
        
        String query = "SELECT * FROM settings WHERE id = ?;";
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
            System.out.println("error at getting settings");
            e.printStackTrace();
        }        
        return entr;
    }
 
    // adds invoice to DB
    private void saveInvoice(int id, double val, String for_m_y, double day_cons, double night_cons, double morning_cons) {
        String query = "INSERT INTO invoice(id_client, value, date, for_month, day_cons, night_cons, morning_cons)" + 
                    "VALUES(?, ?, STR_TO_DATE(CURDATE(), '%Y-%m-%d'), STR_TO_DATE(?, '%Y-%m-%d'), ?, ?, ?)" ;        
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
            st.setDouble(2, val);
            st.setString(3, for_m_y);
            st.setDouble(4, day_cons);
            st.setDouble(5, night_cons);
            st.setDouble(6, morning_cons);

            if((st.executeUpdate()) == 1) {
                System.out.println("Invoice added to DB successfully.");          
            }              
            else
                System.out.println("Invoice not added to DB.");
        }
        catch(Exception e) {
            System.out.println("error at adding data");
            e.printStackTrace();
        }
    }
    
    private int getInvoiceforCM(int id_c, String for_m_y) {
        String query = "SELECT * FROM invoice WHERE id_client = ? and STR_TO_DATE(?, '%Y-%m-%d') = for_month;";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id_c);
            st.setString(2, for_m_y);
            ResultSet rs = st.executeQuery();
            if(rs.next()) { // there already is an invoice in the database for this client and for this month
                return rs.getInt("id_invoice");
            }    
        }
        catch(Exception e) {
            System.out.println("error at getting indexes list");
            e.printStackTrace();
        }
        return -1;
    }
    
    // searches for client with id, returns -1 if not found
    private int getClientWithId(int id) {
        String query = "SELECT * FROM client WHERE id_client = ?";
               
        try (PreparedStatement st = DBConnection.prepareStatement(query);){
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            int count = 0;
            while(rs.next()) 
                count++;
            if(count == 0) { // if there is no client with the given id                
                return -1;
            }               
        }
        catch(Exception e) {
            System.out.println("id not ok");
            e.printStackTrace();
        }
        return id; // valid ID
    }
    
    // inserts new index
    private Integer saveIndex(int id, String dt, String for_m_y, int index_type, double dayIndex, double nightIndex, double morningIndex) {                                                
        String query = "INSERT INTO idx (id_client, date, for_month, index_type, day_index, night_index, morning_index) VALUES (?, STR_TO_DATE(?, '%Y-%m-%d'), STR_TO_DATE(?, '%Y-%m-%d'), ?, ?, ?, ?);";

        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
            st.setString(2, dt);
            st.setString(3, for_m_y);
            st.setInt(4, index_type);
            st.setDouble(5, dayIndex);
            st.setDouble(6, nightIndex);
            st.setDouble(7, morningIndex);

            if((st.executeUpdate()) == 1) {
                return 1;    
            }              
        }
        catch(Exception e) {
            System.out.println("error at adding index");
            e.printStackTrace();
        }
        return -1;
    }            
    
    // updates client with the id and sets the new given data
    private Integer updateClient(int id, String fname, String lname, String addr, String phone) {                                                   
        
        String query = "UPDATE client SET first_name = ?, last_name = ?, address = ?, phone_number = ? WHERE id_client = ? ";
        
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, addr);
            st.setString(4, phone);
            st.setInt(5, id);
            
            if((st.executeUpdate()) == 1) {
                return 1;
            }              
                
        }
        catch(Exception e) {
            System.out.println("error at updating data");
            e.printStackTrace();
        } 
        return -1;
    }              
    
    // delete client with given id
    private Integer deleteClient(int id) {                                                           
        String query = "DELETE FROM client WHERE id_client = ? ";
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setInt(1, id);
        
            if((st.executeUpdate()) == 1) {  
                return 1;                     
            }                             
        }
        catch(Exception e) {
            System.out.println("error at deleting data");
            e.printStackTrace();
        }  
        
        return -1;
    }           
    
    // inserts new client with given info into the DB
    private Integer saveClient(String fname, String lname, String addr, String phone) {                                                
        
        String query = "INSERT INTO client (first_name, last_name, address, phone_number) VALUES (?, ?, ?, ?);" ;
        
        try(PreparedStatement st = DBConnection.prepareStatement(query);) {
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, addr);
            st.setString(4, phone);
            
            if((st.executeUpdate()) == 1) {  
                return 1;                
            }              
            else {
                return -1;     
            }
        }
        catch(Exception e) {
            System.out.println("error at adding data");
            e.printStackTrace();
        }
        return -1;
    }      
    
    
}
