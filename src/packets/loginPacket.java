package packets;

import java.io.Serializable;

public class loginPacket implements Serializable {
    private final String username;
    private final String password;

    public loginPacket(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
