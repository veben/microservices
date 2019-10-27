package com.veben.microservices.order.ext.db;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.validation.constraints.NotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages= {"com.veben.microservices.order.ext.db"})
@Sql(scripts = {"/data/data-local.sql"})
@ActiveProfiles("local")
@ContextConfiguration(initializers = AbstractRepositoryTest.Initializer.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
abstract class AbstractRepositoryTest {

    private static final PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:11.5-alpine");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
            postgresqlContainer
                    .withDatabaseName("order")
                    .withUsername(configurableApplicationContext.getEnvironment().getProperty("spring.datasource.username"))
                    .withPassword(configurableApplicationContext.getEnvironment().getProperty("spring.datasource.password"))
                    .start();
            configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.url", postgresqlContainer.getJdbcUrl());
        }
    }
}
