package classes;

import java.io.Serializable;

public class Settings implements Serializable {
    private final int id;
    private final int sendReminders;
    private final int theme;

    public Settings(int id, int sendReminders, int theme) {
        this.id = id;
        this.sendReminders = sendReminders;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public int getSendReminders() {
        return sendReminders;
    }

    public int getTheme() {
        return theme;
    }
    
    
}
