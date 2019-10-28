package com.veben.microservices.developerinformation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DeveloperInformationApplication {
    public static void main(String[] args) {

        SpringApplication.run(DeveloperInformationApplication.class, args);

        log.info("**********************************************************************");
        log.info("Developer Informations Mircroservice from veben is UP");
        log.info("Health check is available at http://localhost:8092/actuator/health");
        log.info("Swagger is available at http://localhost:8092/swagger-ui.html");
        log.info("Database is available at mongodb://localhost:27018/developer-information");
        log.info("**********************************************************************");
    }
}
