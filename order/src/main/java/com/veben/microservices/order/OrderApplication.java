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
        log.info("Health check is available at localhost:8080/actuator/health");
        log.info("Swagger is available at localhost:8080/swagger-ui.html");
        log.info("**********************************************************************");
    }
}
