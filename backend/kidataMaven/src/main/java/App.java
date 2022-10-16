import com.github.javafaker.Faker;
import database.*;
import java.sql.SQLException;
import java.util.Random;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MySQLManipulation mySQLManipulation = new MySQLManipulation();
        modifyTable("user", "insert", mySQLManipulation);
        mySQLManipulation.close();
    }

    public static void modifyTable(String name, String mode, MySQLManipulation mySQLManipulation) {
        switch (mode) {
            case "insert" -> {
                String[] col = {"uid", "login", "password", "first_name", "last_name", "age", "email"};
                try {
                    for (int i = 0; i < 100; i++) {
                        mySQLManipulation.insert(name, col, randomTable(name), null);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "delete" -> {
                String[] col = {"uid", "login", "password", "first_name", "last_name", "age", "email"};
                String[] val = {"3", "login123", "password123", "first_name123", "last_name123", "12", "email123"};
                try {
                    mySQLManipulation.delete(name, col, val, null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "update" -> {
                String[] col = {"login", "password", "first_name", "last_name", "age", "email"};
                String[] val = {"login12", "password3", "first_name23", "last_name123", "8", "aaa@outlook.com"};
                String[] col2 = {"uid"};
                String[] val2 = {"3"};
                try {
                    mySQLManipulation.update(name, col, val, col2, val2, null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        }
    }

    public static String[] randomTable(String name) {
        String[] emails = {"@gmail.com", "@outlook.com", "@yahoo.com", "hotmail.com"};
        if (name.equals("user")) {
            String uid = String.valueOf((int) (Math.random() * 100000));
            String login = randomString(10);
            String password = randomString(10);
            String firstName = new Faker().name().firstName();
            String lastName = new Faker().name().lastName();
            String email = randomString(10);
            String age = String.valueOf((int) ((Math.random() * 6) + 6));
            return new String[]{uid, login, password, firstName.replace("'",""),
                    lastName.replace("'",""), age,
                    email + emails[new Random().nextInt(emails.length)]};
        }
        return null;
    }

    public static String randomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
