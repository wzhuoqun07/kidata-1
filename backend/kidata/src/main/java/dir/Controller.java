package dir;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tables.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/")
@Configuration
@EnableWebMvc
public class Controller extends WebMvcConfigurerAdapter {

    public Controller() {
        super();
        System.out.println("Controller");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }


    @RequestMapping("/pull/{table}/{id}")
    public String pull(@PathVariable("id") String id, @PathVariable("table") String table) throws SQLException, JSONException {
    String s = "false";
    String [] arr ={};
        System.out.println(table);
        System.out.println(id);
    switch (table){
        case "lesson": s = lesson(id, table, arr, "pull"); break;
        case "slides": s = slides(id, table, arr, "pull"); break;
        case "user": s = user(id, table, arr, "pull"); break;
    }
        return s;
    }

    public String feedback(String id, String table, String[] arr, String instruction) throws SQLException {
        String s = "";
        MySQLManipulation ms = new MySQLManipulation();
        Feedback temp = new Feedback(ms.getConnection());
        switch (instruction){
            case "insert": temp.insert(arr); s = "true"; break;
            case "delete": temp.delete(id); s = "true"; break;
        }
        return s;
    }

    public String lesson(String id, String table, String[] arr, String instruction) throws SQLException, JSONException {
        String s = "";
        MySQLManipulation ms = new MySQLManipulation();
        Lesson temp = new Lesson(ms.getConnection());
        switch (instruction){
            case "insert": temp.insert(arr); s = "true"; break;
            case "delete": temp.delete(id); s = "true"; break;
            case "update": temp.update(arr); s = "true"; break;
            case "pull": s = temp.pull(id).toString(); break;
        }
        return s;
    }

    public String slides(String id, String table, String[] arr, String instruction) throws SQLException, JSONException {
        String s = "";
        MySQLManipulation ms = new MySQLManipulation();
        Slides temp = new Slides(ms.getConnection());
       switch (instruction){
            case "insert": temp.insert(arr); s = "true"; break;
            case "delete": temp.delete(id); s = "true"; break;
            case "update": temp.update(arr); s = "true"; break;
            case "pull": s = temp.pull(id).toString(); break;
        }
        return s;
    }

    public String user (String id, String table, String[] arr, String instruction) throws SQLException, JSONException {
        String s = "";
        System.out.println("here");
        MySQLManipulation ms = new MySQLManipulation();
        User temp = new User(ms.getConnection());
        switch (instruction) {
            case "insert": temp.insert(arr); s = "true"; break;
            case "delete": temp.delete(id); s = "true"; break;
            case "update": temp.update(arr); s = "true"; break;
            case "pull": s = temp.pull(id).toString(); break;
        }
        return s;
    }

    public String userhistory (String id, String table, String[] arr, String instruction) throws SQLException, JSONException {
        MySQLManipulation ms = new MySQLManipulation();
        UserHistory temp = new UserHistory(ms.getConnection());
        temp.insert(arr);
        String s = "true";
        return s;
    }
}
