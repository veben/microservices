package com.veben.microservices.developerinformation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class DeveloperInformationApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(DeveloperInformationApplication.class, args);

        String protocol = context.getEnvironment().getProperty("application.protocol");
        String host = context.getEnvironment().getProperty("application.host");
        String port = context.getEnvironment().getProperty("server.port");
        String name = context.getEnvironment().getProperty("spring.application.name");

        log.info("**********************************************************************");
        log.info("[{}] ℳicroservice from veben is UP", name);
        log.info("Health check is available at {}://{}:{}/actuator/health", protocol, host, port);
        log.info("Swagger is available at {}://{}:{}/swagger-ui.html", protocol, host, port);
        log.info("Database is available using mongodb://{}:27018/{}", host, name);
        log.info("**********************************************************************");
    }
}
