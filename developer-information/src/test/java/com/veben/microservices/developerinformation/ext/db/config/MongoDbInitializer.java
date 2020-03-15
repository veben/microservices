package com.veben.microservices.developerinformation.ext.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.constraints.NotNull;

@Slf4j
class MongoDbInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private MongoDbContainer mongoDbContainer;

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
        mongoDbContainer = new MongoDbContainer();
        mongoDbContainer.start();

        defineMongoDbConnection(configurableApplicationContext);
    }

    private void defineMongoDbConnection(ConfigurableApplicationContext configurableApplicationContext) {
        log.info("Overriding Spring Properties for MongoDb...");

        final TestPropertyValues values = TestPropertyValues.of("spring.data.mongodb.uri="
                + "mongodb://"
                + mongoDbContainer.getContainerIpAddress()
                + ":"
                + mongoDbContainer.getPort()
        );
        values.applyTo(configurableApplicationContext);
    }
}
