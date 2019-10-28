package com.veben.microservices.developerinformation.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeveloperInformationTest {

    @Test
    void should_build_developer_information_with_random_uuid_with_lombok_builder() {
        // given

        // when
        DeveloperInformation developerInformation = DeveloperInformation
                .builder()
                .name("DeveloperInformationsTest")
                .followers(5)
                .build();

        // then
        assertThat(developerInformation.getId()).isNotNull();
    }

    @Test
    void should_build_developer_information_with_random_uuid_with_no_arg_constructor() {
        // given

        // when
        DeveloperInformation developerInformation = new DeveloperInformation();

        // then
        assertThat(developerInformation.getId()).isNotNull();
    }
}