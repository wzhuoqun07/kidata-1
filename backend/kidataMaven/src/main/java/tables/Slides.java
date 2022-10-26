package tables;

import java.sql.Connection;

public class Slides {
    private static final String[] COLUMNS = {"lesson_id", "id", "text", "image", "hint", "title"};

    private Connection c;

    public Slides(Connection c) {
        this.c = c;
    }

    public void insert() {
    }

    public void delete() {

    }

    public void update() {

    }

    public boolean check()  {
        return false;
    }

    public String[] pull() {
        return null;
    }
}
