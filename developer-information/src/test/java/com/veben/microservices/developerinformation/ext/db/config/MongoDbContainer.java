package com.veben.microservices.developerinformation.ext.db.config;

import org.testcontainers.containers.GenericContainer;

import javax.validation.constraints.NotNull;

class MongoDbContainer extends GenericContainer<MongoDbContainer> {

    static final int INTERNAL_EXPOSED_PORT = 27017;
    private static final String DEFAULT_IMAGE_AND_TAG = "mongo:4.2.3";

    MongoDbContainer() {
        this(DEFAULT_IMAGE_AND_TAG);
    }

    MongoDbContainer(@NotNull String image) {
        super(image);
        addExposedPort(INTERNAL_EXPOSED_PORT);
    }

    @NotNull
    Integer getPort() {
        return getMappedPort(INTERNAL_EXPOSED_PORT);
    }
}
