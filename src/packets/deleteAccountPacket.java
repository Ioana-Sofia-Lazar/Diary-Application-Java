package packets;

import java.io.Serializable;

public class deleteAccountPacket implements Serializable {
    private final int id;

    public deleteAccountPacket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}
