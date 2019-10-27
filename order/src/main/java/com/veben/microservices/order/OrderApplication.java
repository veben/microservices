package com.veben.microservices.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class, args);

        log.info("**********************************************************************");
        log.info("Order Mircroservice from veben is UP");
        log.info("Health check is available at http://localhost:8091/actuator/health");
        log.info("Swagger is available at http://localhost:8091/swagger-ui.html");
        log.info("Database is available at jdbc:postgresql://localhost:5434/order");
        log.info("**********************************************************************");
    }
}
