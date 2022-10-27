package tables;

import java.sql.Connection;
import java.sql.SQLException;

public class Feedback {
    private static final String[] cols = {"id", "lesson_id", "description"};
    private Connection c;

    public Feedback(Connection c) {
        this.c = c;
    }

    public void insert(String [] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT IGNORE INTO feedback VALUES ("); 
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

    // needs to be questioned
    public void delete(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("DELETE FROM feedback WHERE ( id = " + val + ");"); 
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }
    
}
