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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class BackendApplication {
    private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);

    public static void main(String[] args) {

        logger.info(" ");
        logger.info("Starting Backend Application ...");
        SpringApplication.run(BackendApplication.class, args);
        logger.info(" ...");
        logger.info("___________________________________________API Backend Application Has Started_____________________________________________________");
    }

}
