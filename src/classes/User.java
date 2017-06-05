package classes;

import java.io.Serializable;
import java.sql.Date;
import javax.swing.ImageIcon;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private Date birthdate;
    private ImageIcon profilePic;

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
