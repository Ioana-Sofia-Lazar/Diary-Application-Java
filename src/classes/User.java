package classes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private Date birthdate;
    private ImageIcon profilePic;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", birthdate=" + birthdate + ", profilePic=" + profilePic + '}';
    }
 

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setProfilePic(ImageIcon profilePic) {
        this.profilePic = profilePic;
    }

    public User(int id, String username, String password, String name, Date birthdate, ImageIcon profilePic) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.profilePic = profilePic;
    }
    
    public User() {
        this.id = 0;
        this.username = "test";
        this.password = "test";
        this.name = "name";
        this.birthdate = Date.valueOf("1996-04-04");
        
        try {
            URL url = new URL("https://www.ravensbourne.ac.uk/content/img/default-pupil-profile.png");
            ImageIcon icon = new ImageIcon(ImageIO.read(url));
            this.profilePic = icon;
        } catch (MalformedURLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public ImageIcon getProfilePic() {
        return profilePic;
    }
    
    
}
