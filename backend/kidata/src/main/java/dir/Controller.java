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

    return s;
    }


}
