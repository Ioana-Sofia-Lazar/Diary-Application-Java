package classes;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import javax.swing.ImageIcon;

public class Entry implements Serializable, Comparable<Entry> {
    private static int idCount = -1;
    private int id;
    private String title;
    private String text;
    private Date date;
    private Time time;
    private ImageIcon pic;
    private String location;
    private boolean added; // if the entry is in the DB or not
    private boolean removed = false;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
     

    public Entry(int id, String title, String text, Date date, Time time, ImageIcon pic, String location, boolean added) {
        if(id == 0) {
            this.id = -idCount;
            idCount--;
        }
        this.title = title;
        this.text = text;
        this.date = date;
        this.added = added;
        this.time = time;
        this.pic = pic;
        this.location = location;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public String getLocation() {
        return location;
    }

    public Time getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    @Override
    public String toString() {
        return "Entry{" + "id=" + id + ", title=" + title + ", text=" + text + ", date=" + date + ", time=" + time + ", location=" + location + ", added=" + added + ", removed=" + removed + '}';
    }

    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public boolean isAdded() {
        return added;
    }

    @Override
    public int compareTo(Entry o) {
        System.err.println("===");
        return time.compareTo(o.getTime());
    }


}
