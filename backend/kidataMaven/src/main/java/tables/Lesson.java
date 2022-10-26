package tables;

import java.sql.Connection;

public class Lesson {
    private static final String[] COLUMNS = {"id", "subject_id", "name"};

    private Connection c;

    public Lesson(Connection c) {
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
