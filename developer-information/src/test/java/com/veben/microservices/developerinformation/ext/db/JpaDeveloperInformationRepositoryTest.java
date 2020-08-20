package com.veben.microservices.developerinformation.ext.db;

import com.veben.microservices.developerinformation.ext.db.config.AbstractRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.veben.microservices.developerinformation.ext.db.utils.DeveloperInformationUtils.insertExampleJson;
import static org.assertj.core.api.Assertions.assertThat;

class JpaDeveloperInformationRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private JpaDeveloperInformationRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
        Arrays.stream(insertExampleJson("mongo/data-local.json")).forEach(repository::save);
    }

    @Test
    void should_find_all_informations() {
        // when
        final var allInformations = repository.findAllInformations();

        // then
        assertThat(allInformations.size()).isEqualTo(36);
    }

    @Test
    void should_find_developer_information_for_developer() {
        // given
        final var givenDevId = "3bdfbba3-d472-4431-b9ac-c203e7505b8b";

        // when
        final var result = repository.findDeveloperInformationForDeveloper(givenDevId);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("veben");
    }
}
