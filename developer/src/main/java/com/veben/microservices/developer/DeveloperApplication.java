package com.veben.microservices.developer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DeveloperApplication {
    public static void main(String[] args) {

        SpringApplication.run(DeveloperApplication.class, args);

        log.info("**********************************************************************");
        log.info("Developer Mircroservice from veben is UP");
        log.info("Health check is available at http://localhost:8090/actuator/health");
        log.info("Swagger is available at http://localhost:8090/swagger-ui.html");
        log.info("Database is available at jdbc:postgresql://localhost:5433/developer");
        log.info("**********************************************************************");
    }
}
