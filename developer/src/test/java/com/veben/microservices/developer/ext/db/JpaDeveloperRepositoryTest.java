package com.veben.microservices.developer.ext.db;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperSearchCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class JpaDeveloperRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private JpaDeveloperRepository jpaDeveloperRepository;

    @Test
    void should_find_all_developers_when_no_params() {
        // given
        final DeveloperSearchCriteria criteria = new DeveloperSearchCriteria();

        // when
        final Set<Developer> allDevelopers = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

        // then
        assertThat(allDevelopers).isNotEmpty();
    }

    @Test
    void should_find_developer_with_similar_nickname() {
        // given
        final DeveloperSearchCriteria criteria = new DeveloperSearchCriteria()
                .nickname("vebEn");

        // when
        final Set<Developer> developersByLocation = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

        // then
        assertThat(developersByLocation).isNotEmpty();
    }

    @Test
    void should_find_developer_with_similar_location() {
        // given
        final DeveloperSearchCriteria criteria = new DeveloperSearchCriteria()
                .location("FR");

        // when
        final Set<Developer> developersBySpeciality = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

        // then
        assertThat(developersBySpeciality).isNotEmpty();
    }

    @Test
    void should_find_developer_with_similar_speciality() {
        // given
        final DeveloperSearchCriteria criteria = new DeveloperSearchCriteria()
                .speciality("c");

        // when
        final Set<Developer> developersBySpeciality = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

        // then
        assertThat(developersBySpeciality).isNotEmpty();
    }

    @Test
    void should_find_developer_with_similar_nickname_speciality_and_location() {
        // given
        final DeveloperSearchCriteria criteria = new DeveloperSearchCriteria()
                .nickname("veben")
                .speciality("java")
                .location("France");

        // when
        final Set<Developer> developersBySpeciality = jpaDeveloperRepository.findDevelopersByLocationAndSpeciality(criteria);

        // then
        assertThat(developersBySpeciality).isNotEmpty();
    }

    @Test
    void should_find_all_specialities() {
        // when
        final Set<String> developersSpecialities = jpaDeveloperRepository.findAllDevelopersSpecialities();

        // then
        assertThat(developersSpecialities).isNotEmpty();
    }
}