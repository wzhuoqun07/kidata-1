package kidata.dir;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
    @RequestMapping("/hello")
    public String Hello() {
        return "Hello";
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

    @RequestMapping("/fetch")
    @CrossOrigin(origins = "http://localhost:8080/fetch")
    public String fetchUser(String id) {
        JSONObject user = new JSONObject();
        try {
            user.put("id", id);
            user.put("name", "John");
            user.put("age", "20");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.toString();
    }
}
