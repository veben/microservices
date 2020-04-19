package com.veben.microservices.developer.ext.rest;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperRepository;
import com.veben.microservices.developer.ext.client.DeveloperInformationService;
import com.veben.microservices.developer.ext.client.dto.DeveloperInformationDto;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Optional;
import java.util.Set;

import static com.veben.microservices.developer.ext.rest.DeveloperController.DEVELOPERS_URI;
import static com.veben.microservices.developer.ext.rest.DeveloperController.DEVELOPER_SPECIALITY_URI;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DeveloperController.class)
class DeveloperControllerTest {

    @MockBean
    private DeveloperRepository developerRepository;
    @MockBean
    private DeveloperInformationService developerInformationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_ok_developers_when_data_developer() throws Exception {
        // given
        when(developerRepository.findDevelopersByLocationAndSpeciality(any()))
                .thenReturn(Set.of(new Developer("veben", "France", "java", "")));

        // when
        mockMvc.perform(get(DEVELOPERS_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk());
    }

    @Test
    void should_return_ok_when_data_speciality() throws Exception {
        // given
        when(developerRepository.findAllDevelopersSpecialities())
                .thenReturn(Set.of("java", "angular"));

        // when
        mockMvc.perform(get(DEVELOPER_SPECIALITY_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk());
    }

    @Nested
    class should_test_developer_informations {
        @Test
        void should_return_ok_when_data_information() throws Exception {
            // given
            final var id = "d15a5fb3-a157-4d13-ad2d-c8add8250e25";
            final var url = DEVELOPERS_URI + "/" + id + "/developer-informations";
            when(developerInformationService.getDeveloperInformationById(id))
                    .thenReturn(Optional.of(new DeveloperInformationDto()));

            // when
            mockMvc.perform(get(url))
                    .andDo(MockMvcResultHandlers.print())
                    // then
                    .andExpect(status().isOk());
        }

        @Test
        void should_return_not_found_when_unknown_id() throws Exception {
            // given
            final var url = DEVELOPERS_URI + "/" + "unknown-id" + "/developer-informations";

            // when
            mockMvc.perform(get(url))
                    .andDo(MockMvcResultHandlers.print())
                    // then
                    .andExpect(status().isNotFound());
        }
    }
}