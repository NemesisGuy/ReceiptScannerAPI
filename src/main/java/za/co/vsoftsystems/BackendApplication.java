package za.co.vsoftsystems;
/**
 * BackendApplication.java
 * This is the main class for the backend
 * Author: Peter Buckingham (220165289)
 * Date: 20 Sep 2023
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    //factory, repos, domain, controllers and services
}
