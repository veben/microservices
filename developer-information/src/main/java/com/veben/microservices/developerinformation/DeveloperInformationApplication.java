package com.veben.microservices.developerinformation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class DeveloperInformationApplication {
    public static void main(String[] args) {

        var context = SpringApplication.run(DeveloperInformationApplication.class, args);

        logStartupInformations(context);
    }

    private static void logStartupInformations(ConfigurableApplicationContext context) {
        var protocol = context.getEnvironment().getProperty("application.protocol");
        var host = context.getEnvironment().getProperty("application.host");
        var port = context.getEnvironment().getProperty("server.port");
        var name = context.getEnvironment().getProperty("spring.application.name");

        log.info("**********************************************************************");
        log.info("[{}] ℳicroservice from veben is UP", name);
        log.info("Health check is available at {}://{}:{}/actuator/health", protocol, host, port);
        log.info("Swagger is available at {}://{}:{}/swagger-ui.html", protocol, host, port);
        log.info("Database is available using mongodb://{}:27018/{}", host, name);
        log.info("**********************************************************************");
    }
}
