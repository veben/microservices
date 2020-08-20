package com.veben.microservices.developer.ext.db;

import com.veben.microservices.developer.domain.DeveloperSearchCriteria;
import com.veben.microservices.developer.ext.db.config.AbstractRepositoryTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class JpaDeveloperRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private JpaDeveloperRepository jpaDeveloperRepository;

    @Nested
    class should_test_developers_by_location_and_speciality {
        @Test
        void should_find_all_developers_when_no_params() {
            // given
            final var criteria = new DeveloperSearchCriteria();

            // when
            final var allDevelopers = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

            // then
            assertThat(allDevelopers).isNotEmpty();
        }

        @Test
        void should_find_developer_with_similar_nickname() {
            // given
            final var criteria = new DeveloperSearchCriteria()
                    .nickname("vebEn");

            // when
            final var developersByLocation = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

            // then
            assertThat(developersByLocation).isNotEmpty();
        }

        @Test
        void should_find_developer_with_similar_location() {
            // given
            final var criteria = new DeveloperSearchCriteria()
                    .location("FR");

            // when
            final var developersBySpeciality = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

            // then
            assertThat(developersBySpeciality).isNotEmpty();
        }

        @Test
        void should_find_developer_with_similar_speciality() {
            // given
            final var criteria = new DeveloperSearchCriteria()
                    .speciality("c");

            // when
            final var developersBySpeciality = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

            // then
            assertThat(developersBySpeciality).isNotEmpty();
        }

        @Test
        void should_find_developer_with_similar_nickname_speciality_and_location() {
            // given
            final var criteria = new DeveloperSearchCriteria()
                    .nickname("veben")
                    .speciality("java")
                    .location("France");

            // when
            final var developersBySpeciality = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

            // then
            assertThat(developersBySpeciality).isNotEmpty();
        }
    }

    @Test
    void should_find_all_specialities() {
        // when
        final var developersSpecialities = jpaDeveloperRepository.findAllDevelopersSpecialities();

        // then
        assertThat(developersSpecialities).isNotEmpty();
    }
}