package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONObject;

public class Subject {
    private static final String[] COLUMNS = {"id", "name"};

    private Connection c;

    public Subject(Connection c) {
        this.c = c;
    }

    public void insert(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT IGNORE INTO Subject VALUES (");
        sql.append(vals[2] + ", " + vals[3] + ");" );
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }

    public void delete(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("DELETE FROM Subject WHERE ( id = " + val + ");"); 
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }

    @SuppressWarnings("unchecked")
    public JSONObject pull(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("Select * From slides where UserID = " + val);
        ResultSet rs = ((Statement) c.createStatement()).executeQuery(sql.toString());
        JSONObject item = new JSONObject();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            item.put("id", id);
            String name = rs.getString("name");
            item.put("name", name);
        }
        return item;
    }
}
