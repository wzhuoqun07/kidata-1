package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Slides {
    private static final String[] COLUMNS = { "id", "lesson_id", "text",
        "image", "hint", "title" };
    private Connection c;

    public Slides(Connection c) {
        this.c = c;
    }


    public void insert(String[] vals) throws SQLException {
        StringBuilder sq = new StringBuilder(
            "SELECT * FROM kidata.slides where id = (select max(id) from kidata.slides)");
        Statement s = (Statement)c.createStatement();
        int index = 0;
        ResultSet rs = s.executeQuery(sq.toString());
        while (rs.next()) {
            index = rs.getInt("id");
            index++;
        }

        StringBuilder sql = new StringBuilder(
            "INSERT IGNORE INTO slides VALUES ('" + index + "',");
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
        StringBuilder sql = new StringBuilder("DELETE FROM slides WHERE ( lesson_id = "
            + val + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }


    public void update(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE slides SET ");
        for (int i = 2; i < vals.length - 1; i = i + 2) {

            sql.append(vals[i] + " = ");
            sql.append("'").append(vals[i + 1]).append("'");
            // set(id = '3',....)

            if (i != vals.length - 3) {
                sql.append(", ");
            }
        }

        sql.append(" WHERE( id = " + vals[4] + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }


    @SuppressWarnings("unchecked")
    public JSONObject pull(String val) throws SQLException, JSONException {
        StringBuilder sql = new StringBuilder("Select * From slides where lesson_id = "
            + val);
        Statement s = (Statement)c.createStatement();
        System.out.println(sql);

        ResultSet rs = s.executeQuery(sql.toString());
        JSONObject item = new JSONObject();

        while (rs.next()) {
            int id = rs.getInt("id");
            item.put("id", id);
            int lesson_id = rs.getInt("lesson_id");
            item.put("lesson_id", lesson_id);
            String text = rs.getString("markdown");
            item.put("markdown", text);
            String quiz = rs.getString("quiz");
            item.put("quiz", quiz);
        }

        return item;
    }
}
