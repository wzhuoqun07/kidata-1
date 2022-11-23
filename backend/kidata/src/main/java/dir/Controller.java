package dir;

import org.jetbrains.annotations.NotNull;
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
        System.out.print(table);
        System.out.println(id);
    switch (table){
        case "lesson": s = lesson(id, table, arr, "pull"); break;
        case "slides": s = slides(id, table, arr, "pull"); break;
        case "user": s = user(id, table, arr, "pull"); break;
    }
        return s;
    }

    @RequestMapping("delete/{table}/{id}")
    public String delete(@PathVariable("id") String id, @PathVariable("table") String table) throws SQLException, JSONException {
        String s = "true";
        String [] arr ={};
        System.out.print(table);
        System.out.println(id);
        switch (table){
            case "lesson": lesson(id, table, arr, "delete"); break;
            case "slides": slides(id, table, arr, "delete"); break;
            case "user": user(id, table, arr, "delete"); break;
            case "feedback": feedback(id, table, arr, "delete"); break;
        }
        return s;
    }

    @RequestMapping("update/{table}/{info}")
    public String update(@PathVariable("table") String table, @PathVariable("info") String info) throws SQLException, JSONException {
        String s = "true";
        String [] arr = info.split("-");
        System.out.print(table);
        String id = null;
        switch (table){
            case "lesson": lesson(id, table, arr, "update"); break;
            case "slides": slides(id, table, arr, "update"); break;
            case "user": user(id, table, arr, "update"); break;
        }
        return s;
    }

    @RequestMapping("push/{table}/{info}")
    public String insert(@PathVariable("table") String table, @PathVariable("info") String info) throws SQLException, JSONException {
        String s = "true";
        String [] arr = info.split("-");
        System.out.print(table);
        String id = null;
        switch (table){
            case "lesson": lesson(id, table, arr, "insert"); break;
            case "slides": slides(id, table, arr, "insert"); break;
            case "user": user(id, table, arr, "insert"); break;
            case "feedback": feedback(id, table, arr, "insert"); break;
            case "userhistory": userhistory(id, table, arr, "insert"); break;
        }
        return s;
    }

    @RequestMapping("check/{what}/{text}")
    public String check(@PathVariable("what") String what, @PathVariable("text") String text) throws SQLException, JSONException {
        MySQLManipulation ms = new MySQLManipulation();
        User us = new User(ms.getConnection());
        String [] arr = text.split("-");
        String s = "";
        switch(what){
            case "login": s = us.check(arr[0], arr[1]); break;
            case "profile": s = us.checkExists(arr[0]); break;
        }
        return s;
    }

    public String feedback(String id, String table, String[] arr, @NotNull String instruction) throws SQLException {
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
