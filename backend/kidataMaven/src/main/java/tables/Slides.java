package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONObject;

public class Slides {
    private static final String[] COLUMNS = {"lesson_id", "id", "text", "image", "hint", "title"};
    private Connection c;

    
    public Slides(Connection c) {
        this.c = c;
    }

    
    
    public void insert(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT IGNORE INTO Slides VALUES ("); 
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
        StringBuilder sql = new StringBuilder("DELETE FROM slides WHERE ( id = " + val + ");"); 
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }

    
    
    public void update(String[] vals) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE lesson SET(");
        for (int i = 2; i < vals.length-1; i = i+2) {
            
            sql.append(vals[i]+ " = ");
            sql.append("'").append(vals[i+1]).append("'");
            //set(id = '3',....)
            
            if (i != vals.length - 2) {
                sql.append(", ");
            }
        }
        
        sql.append(" WHERE( id = " + vals[4] + ");");
        System.out.println(sql);
        c.createStatement().execute(sql.toString());
    }

    
    
    @SuppressWarnings("unchecked")
    public JSONObject pull(String val) throws SQLException {
        StringBuilder sql = new StringBuilder("Select * From slides where UserID = " + val);
        ResultSet rs = ((Statement) c.createStatement()).executeQuery(sql.toString());
        JSONObject item = new JSONObject();
        
        while (rs.next()) {
            int lesson_id = rs.getInt("lesson_id");
            item.put("lesson_id", lesson_id);
            int id = rs.getInt("id");
            item.put("id", id);
            String text = rs.getString("text");
            item.put("text", text);
            String image = rs.getString("image");
            item.put("image", image);
            String hint = rs.getString("hint");
            item.put("hint", hint);
            String title = rs.getString("title");
            item.put("title", title);
            
        }
        
        return item;
    }
}
