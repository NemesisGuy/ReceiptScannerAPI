package za.co.vsoftsystems;
/**
 * Author: Peter Buckingham (220165289)
 * BackendApplication.java
 * This is the main class for the backend application, this class will be used to run the backend application
 *
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
