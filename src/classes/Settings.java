package classes;

import java.io.Serializable;

public class Settings implements Serializable {
    private int id;
    private int sendReminders;
    private int theme;

    public Settings(int id, int sendReminders, int theme) {
        this.id = id;
        this.sendReminders = sendReminders;
        this.theme = theme;
    }
    
    public Settings() {
        this.id = 0;
        this.sendReminders = 1;
        this.theme = 0;
    }

    @Override
    public String toString() {
        return "Settings{" + "id=" + id + ", sendReminders=" + sendReminders + ", theme=" + theme + '}';
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

    public void setId(int id) {
        this.id = id;
    }

    public void setSendReminders(int sendReminders) {
        this.sendReminders = sendReminders;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }
    
    
}
