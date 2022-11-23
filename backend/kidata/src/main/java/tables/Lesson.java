package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Lesson {
    private static final String[] COLUMNS = { "id", "subject_id", "name" };

    private Connection c;

    public Lesson(Connection c) {
        this.c = c;
    }


    public void insert(String[] vals) throws SQLException {
        StringBuilder sq = new StringBuilder(
            "SELECT * FROM kidata.lesson where id = (select max(id) from kidata.lesson)");
        Statement s = (Statement)c.createStatement();
        int index = 0;
        ResultSet rs = s.executeQuery(sq.toString());
        while (rs.next()) {
            index = rs.getInt("id");
            index++;
        }

        StringBuilder sql = new StringBuilder(
            "INSERT IGNORE INTO lesson VALUES ('" + index + "',");
        for (int i = 0; i < vals.length; i++) {
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
        StringBuilder sql = new StringBuilder("DELETE FROM lesson WHERE ( id = "
            + val + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }


    public void update(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE lesson SET " + vals[2]);
        sql.append(" = '" + vals[3] + "' WHERE( id = " + vals[4] + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }


    @SuppressWarnings("unchecked")
    public JSONObject pull(String val) throws SQLException, JSONException {
        StringBuilder sql = new StringBuilder("Select * From lesson where id = "
            + val);
        Statement s = (Statement)c.createStatement();
        System.out.println(sql);

        ResultSet rs = s.executeQuery(sql.toString());
        JSONObject item = new JSONObject();

        while (rs.next()) {
            int id = rs.getInt("id");
            item.put("id", id);
            int subjectid = rs.getInt("subject_id");
            item.put("subject_id", subjectid);
            String name = rs.getString("name");
            item.put("name", name);
        }

        return item;
    }
}
