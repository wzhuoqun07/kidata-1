package tables;

import java.sql.Connection;
import java.sql.SQLException;

public class UserHistory {
    private static final String[] COLUMNS = {"id", "user_id", "start_time", "end_time"};

    private Connection c;

    public UserHistory(Connection c) {
        this.c = c;
    }

    public void insert(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT IGNORE INTO userhistory VALUES ("); 
        for (int i = 2; i < vals.length; i++) {
            sql.append("'").append(vals[i]).append("'");
            if (i != vals.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        sql.append(";");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }
}
