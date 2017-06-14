/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class closeAppPacket implements Serializable {
    private HashMap<Date, ArrayList<Entry>> ENTRIES;
    private User USER;
    private Settings SETTINGS;

    public closeAppPacket(HashMap<Date, ArrayList<Entry>> ENTRIES, User USER, Settings SETTINGS) {
        this.ENTRIES = ENTRIES;
        this.USER = USER;
        this.SETTINGS = SETTINGS;
    }

    public HashMap<Date, ArrayList<Entry>> getENTRIES() {
        return ENTRIES;
    }

    public User getUSER() {
        return USER;
    }

    public Settings getSETTINGS() {
        return SETTINGS;
    }
    
    
}
