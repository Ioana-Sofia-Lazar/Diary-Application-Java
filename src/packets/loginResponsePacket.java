package packets;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class loginResponsePacket implements Serializable {
    private final User user;
    private final Settings settings;
    private HashMap<Integer, Entry> entries;

    public User getUser() {
        return user;
    }

    public Settings getSettings() {
        return settings;
    }

    public HashMap<Integer, Entry> getEntries() {
        return entries;
    }

    public loginResponsePacket(User user, Settings settings, HashMap<Integer, Entry> entries) {
        this.user = user;
        this.settings = settings;
        this.entries = entries;
    }
}
