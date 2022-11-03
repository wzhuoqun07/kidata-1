package kidata.dir;

import kidata.tables.MySQLManipulation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class KidataApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidataApplication.class, args);
        MySQLManipulation m = new MySQLManipulation();

    }

}
