
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONObject;

public class User {
    private static final String[] COLUMNS = { "uid", "login", "password",
        "first_name", "last_name", "age", "email", "type", "points" };

    private Connection c;

    public User(Connection c) {
        this.c = c;
    }


    public void insert(String[] vals) throws SQLException {
        StringBuilder sq = new StringBuilder(
            "SELECT * FROM kidata.Users where uid = (select max(uid) from kidata.users)");
        Statement s = (Statement)c.createStatement();
        int index = 0;
        ResultSet rs = s.executeQuery(sq.toString());
        while (rs.next()) {
            index = rs.getInt("uid");
            index++;
        }

        StringBuilder sql = new StringBuilder(
            "INSERT IGNORE INTO users VALUES ('" + index + "',");
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
        StringBuilder sql = new StringBuilder("DELETE FROM users WHERE ( uid = "
            + val + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }


    @SuppressWarnings("unchecked")
    public JSONObject pull(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("Select * From users where uid = "
            + val);
        ResultSet rs = ((Statement)c.createStatement()).executeQuery(sql
            .toString());
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
    public boolean check(String username, String password) throws SQLException {
        StringBuilder sql = new StringBuilder(
            "Select * From kidata.users where login = '" + username + "'");
        Statement s = (Statement)c.createStatement();
        System.out.println(sql);

        ResultSet rs = s.executeQuery(sql.toString());
        String pass = "";
        while (rs.next()) {
            pass = rs.getString("password");
        }
        if (pass.compareTo(password) == 0) {
            return true;
        }
        return false;
    }


    public void update(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE users SET ");
        for (int i = 2; i < vals.length - 1; i = i + 2) {

            sql.append(vals[i] + " = ");
            sql.append("'").append(vals[i + 1]).append("'");
            // set(id = '3',....)

            if (i != vals.length - 3) {
                sql.append(", ");
            }
        }

        sql.append(" WHERE( uid = " + vals[vals.length - 1] + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }
}
