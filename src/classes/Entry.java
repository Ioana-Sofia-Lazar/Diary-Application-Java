package classes;

import java.io.Serializable;
import java.sql.Date;

public class Entry implements Serializable {
    private final int id;
    private final String title;
    private final String text;
    private final Date date;

    public Entry(int id, String title, String text, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
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


}
