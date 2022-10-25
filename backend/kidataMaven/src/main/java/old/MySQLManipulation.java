package old;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManipulation {
    // modify this to your own database
    private final String url = "jdbc:mysql://localhost:3306/kidata";
    private final String username = "root";
    private final String password = "Zsl020210#";
    private Connection c;

    public MySQLManipulation() {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws ClassNotFoundException {
        System.out.println("Connecting database...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public void insert(String name, String @NotNull [] cols, String[] vals, String tcl) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT IGNORE INTO " + name + " (");
        for (int i = 0; i < cols.length; i++) {
            sql.append(cols[i]);
            if (i != cols.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(") VALUES (");
        for (int i = 0; i < vals.length; i++) {
            sql.append("'").append(vals[i]).append("'");
            if (i != vals.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        if (tcl != null) {
            sql.append(" ").append(tcl);
        }
        sql.append(";");
        c.createStatement().execute(sql.toString());
    }

    public void delete(String name, String col, String[] vals, String tcl) throws SQLException {
        StringBuilder sql = new StringBuilder("DELETE FROM " + name + " WHERE " + col + " IN (");
        for (int i = 0; i < vals.length; i++) {
            sql.append(vals[i]);
            if (i != vals.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        if (tcl != null) {
            sql.append(" ").append(tcl);
        }
        sql.append(";");
        c.createStatement().execute(sql.toString());
    }

    public void update(String name, String[] cols, String[] vals, String[] cols2, String[] vals2,
                       String tcl) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE IGNORE" + name + " SET ");
        for (int i = 0; i < cols.length; i++) {
            sql.append(cols[i]).append(" = '").append(vals[i]).append("'");
            if (i != cols.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE ");
        for (int i = 0; i < cols2.length; i++) {
            sql.append(cols2[i]).append(" = '").append(vals2[i]).append("'");
            if (i != cols2.length - 1) {
                sql.append(" AND ");
            }
        }
        if (tcl != null) {
            sql.append(" ").append(tcl);
        }
        sql.append(";");
        c.createStatement().execute(sql.toString());
    }

    public void select(String name, String[] cols, String[] vals, String tcl) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT ");
        for (int i = 0; i < cols.length; i++) {
            sql.append(cols[i]);
            if (i != cols.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(" FROM ").append(name);
        if (vals != null) {
            sql.append(" WHERE ");
            for (int i = 0; i < vals.length; i++) {
                sql.append(vals[i]);
                if (i != vals.length - 1) {
                    sql.append(" AND ");
                }
            }
        }
        if (tcl != null) {
            sql.append(" ").append(tcl);
        }
        sql.append(";");
        c.createStatement().execute(sql.toString());
    }

    public void close() throws SQLException {
        c.close();
    }
}




