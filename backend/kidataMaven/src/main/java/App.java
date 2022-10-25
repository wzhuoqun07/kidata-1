import com.github.javafaker.Faker;
import old.MySQLManipulation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

public class App {
    private static final String[] TABLES = {"user", "feedback", "lesson", "subject", "user_history"};
    private static final String[] OPERATIONS = {"insert", "delete", "update"};

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();
        MySQLManipulation mySQLManipulation = (MySQLManipulation) context.getBean("mySQLManipulation");
        modifyTable(TABLES[0], OPERATIONS[0], mySQLManipulation);
        mySQLManipulation.close();
    }

    public static void modifyTable(String name, String mode, MySQLManipulation mySQLManipulation) {
        switch (name){
            case "user" -> modifyUser(mode, mySQLManipulation);
            case "feedback" -> modifyFeedback(mode, mySQLManipulation);
            //case "lesson" -> modifyLesson(mode, mySQLManipulation);
            //case "subject" -> modifySubject(mode, mySQLManipulation);
            //case "user_history" -> modifyUserHistory(mode, mySQLManipulation);

            default -> throw new IllegalStateException("Unexpected value: " + mode);
        }
    }

    private static void modifyFeedback(String mode, MySQLManipulation mySQLManipulation) {
        String[] col = {"id", "lesson_id", "description"};
        switch (mode) {
            case "insert" -> {
                try {
                    for (int i = 0; i < 100; i++) {
                        mySQLManipulation.insert("feedback", col, randomVals("feedback"), null);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "delete" -> {
                try {
                    mySQLManipulation.delete("feedback", col[0], new String[]{"1"}, null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "update" -> {

            }
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        }
    }

    public static void modifyUser(String mode, MySQLManipulation mySQLManipulation) {
        String[] col = {"uid", "login", "password", "first_name", "last_name", "age", "email"};
        switch (mode) {
            case "insert" -> {
                try {
                    for (int i = 0; i < 100; i++) {
                        mySQLManipulation.insert("user", col, randomVals("user"), null);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "delete" -> {
                try {
                    mySQLManipulation.delete("user", col[0],
                            new String[]{"13386", "40687"}, null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "update" -> {

            }
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        }
    }

    public static String[] randomVals(String name) {
        String[] emails = {"@gmail.com", "@outlook.com", "@yahoo.com", "hotmail.com"};
        switch (name) {
            case "user" -> {
                return new String[]{String.valueOf((int) (Math.random() * 100000)), randomString(10),
                        randomString(10), new Faker().name().firstName().replace("'",""),
                        new Faker().name().lastName().replace("'",""),
                        String.valueOf((int) ((Math.random() * 6) + 6)),
                        randomString(10) + emails[new Random().nextInt(emails.length)]};
            }
            case "feedback" -> {
                return new String[]{String.valueOf((int) (Math.random() * 100000)),
                        String.valueOf((int) (Math.random() * 100000)),
                        new Faker().lorem().paragraph()};
            }
//            case "lesson" -> {
//
//            }
//            case "subject" -> {
//
//            }
//            case "user_history" -> {
//
//            }
            default -> throw new IllegalStateException("Unexpected value: " + name);
        }
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
