package tables;

import java.sql.Connection;

public class User {
    private static final String[] COLUMNS = {"uid", "login", "password", "first_name",
                                            "last_name", "age", "email", "type", "points"};

    private Connection c;

    public User(Connection c) {
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
