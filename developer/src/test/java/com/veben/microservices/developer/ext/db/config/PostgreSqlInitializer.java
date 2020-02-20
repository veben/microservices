package com.veben.microservices.developer.ext.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.validation.constraints.NotNull;

@Slf4j
class PostgreSqlInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:11.5-alpine");

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
        postgresqlContainer
                .withDatabaseName("developer")
                .withUsername(configurableApplicationContext.getEnvironment().getProperty("spring.datasource.username"))
                .withPassword(configurableApplicationContext.getEnvironment().getProperty("spring.datasource.password"))
                .start();
        configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.url", postgresqlContainer.getJdbcUrl());
    }
}
