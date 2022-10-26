package tables;

import java.sql.Connection;

public class UserHistory {
    private static final String[] COLUMNS = {"id", "user_id", "start_time", "end_time"};

    private Connection c;

    public UserHistory(Connection c) {
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
