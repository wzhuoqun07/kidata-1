package tables;

import java.sql.Connection;

public class Subject {
    private static final String[] COLUMNS = {"id", "name"};

    private Connection c;

    public Subject(Connection c) {
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
