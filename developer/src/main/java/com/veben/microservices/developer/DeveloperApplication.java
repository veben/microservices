package com.veben.microservices.developer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class DeveloperApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(DeveloperApplication.class, args);

        String protocol = context.getEnvironment().getProperty("application.protocol");
        String host = context.getEnvironment().getProperty("application.host");
        String port = context.getEnvironment().getProperty("server.port");
        String name = context.getEnvironment().getProperty("spring.application.name");

        log.info("**********************************************************************");
        log.info("[{}] ℳicroservice from veben is UP", context.getEnvironment().getProperty("spring.application.name"));
        log.info("Health check is available at {}://{}:{}/actuator/health", protocol, host, port);
        log.info("Swagger is available at {}://{}:{}/swagger-ui.html", protocol, host, port);
        log.info("Database is available using jdbc:postgresql://{}:5433/{}", host, name);
        log.info("**********************************************************************");
    }
}
