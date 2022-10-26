package tables;

import java.sql.Connection;

public class Feedback {
    private static final String[] COLUMNS = {"id", "lesson_id", "description"};
    private Connection c;

    public Feedback(Connection c) {
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
}
