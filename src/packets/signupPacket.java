package packets;

import java.io.Serializable;

public class signupPacket implements Serializable {
    private final String username;
    private final String password;

    public String getPassword() {
        return password;
    }
    
    public signupPacket(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

}
