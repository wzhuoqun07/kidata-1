
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserHistory {
    private static final String[] COLUMNS = { "id", "user_id", "start_time",
        "end_time" };

    private Connection c;

    public UserHistory(Connection c) {
        this.c = c;
    }


    public void insert(String[] vals) throws SQLException {
        StringBuilder sq = new StringBuilder(
            "SELECT * FROM kidata.userhistory where id = (select max(id) from kidata.userhistory)");
        Statement s = (Statement)c.createStatement();
        int index = 0;
        ResultSet rs = s.executeQuery(sq.toString());
        while (rs.next()) {
            index = rs.getInt("id");
            index++;
        }

        StringBuilder sql = new StringBuilder(
            "INSERT IGNORE INTO userhistory VALUES ('" + index + "',");
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
