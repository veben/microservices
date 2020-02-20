package com.veben.microservices.developerinformation.ext.db.config;

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataMongoTest
@ContextConfiguration(initializers = MongoDbInitializer.class)
@ActiveProfiles("local")
@Testcontainers(disabledWithoutDocker = true)
public abstract class AbstractRepositoryTest {
}
