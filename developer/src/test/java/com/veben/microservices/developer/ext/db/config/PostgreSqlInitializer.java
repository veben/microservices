package com.veben.microservices.developer.ext.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.validation.constraints.NotNull;

@Slf4j
class PostgreSqlInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String POSTGRES_IMAGE = "postgres:12.2-alpine";
    private static final String DATABASE = "developer";
    private static final String USERNAME_PROPERTY = "spring.datasource.username";
    private static final String PASSWD_PROPERTY = "spring.datasource.password";
    private static final String URL_PROPERTY = "spring.datasource.url";

    private final PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer(POSTGRES_IMAGE);

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {

        log.info("Initilizing postgres containert to perform repository tests");

        postgresqlContainer
                .withDatabaseName(DATABASE)
                .withUsername(configurableApplicationContext.getEnvironment().getProperty(USERNAME_PROPERTY))
                .withPassword(configurableApplicationContext.getEnvironment().getProperty(PASSWD_PROPERTY))
                .start();
        configurableApplicationContext.getEnvironment().getSystemProperties().put(URL_PROPERTY, postgresqlContainer.getJdbcUrl());
    }
}
