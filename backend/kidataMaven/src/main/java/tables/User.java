package tables;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONObject;

public class User {
    private static final String[] COLUMNS = {"uid", "login", "password", "first_name",
                                            "last_name", "age", "email", "type", "points"};

    private Connection c;

    public User(Connection c) {
        this.c = c;
    }

    public void insert(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT IGNORE INTO user VALUES ("); 
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

    
    
    public void delete(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("DELETE FROM user WHERE ( id = " + val + ");"); 
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }

    
    
    @SuppressWarnings("unchecked")
    public JSONObject pull(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("Select * From slides where UserID = " + val);
        ResultSet rs = ((Statement) c.createStatement()).executeQuery(sql.toString());
        JSONObject item = new JSONObject();
        
        while (rs.next()) {
            int uid = rs.getInt("uid");
            item.put("uid", uid);
            int age = rs.getInt("age");
            item.put("age", age);
            String password = rs.getString("password");
            item.put("password", password);
            String first_name = rs.getString("first_name");
            item.put("first_name", first_name);
            String last_name = rs.getString("last_name");
            item.put("last_name", last_name);
            String email = rs.getString("email");
            item.put("email", email);
            String type = rs.getString("type");
            item.put("type", type);
            int points = rs.getInt("points");
            item.put("points", points);
        }
        return item;
    }

    
    
    // possible chance of error due to not using while loop
    public boolean check(String username, String password) throws SQLException  {
        StringBuilder sql = new StringBuilder("Select * From slides where UserID = " + username);
        ResultSet rs = ((Statement) c.createStatement()).executeQuery(sql.toString());
        if (rs.last() && rs.getString("password") == password) {
            return true;
        }
        return false;
    }

    
    
    // finish this
    public String[] pull() {
        return null;
    }
}

