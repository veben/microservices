package com.veben.microservices.developer.ext.rest;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperRepository;
import com.veben.microservices.developer.ext.client.DeveloperInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeveloperController.class)
class DeveloperControllerTest {

    private static final String DEVELOPER_PATH = "/api/developer/v1/developers/";
    private static final String DEVELOPER_SPECIALITY_URI = DEVELOPER_PATH + "/list-specialities";

    @MockBean
    private DeveloperRepository developerRepository;
    @MockBean
    private DeveloperInformationService developerInformationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_no_content_when_no_data_developer() throws Exception {
        // given
        when(developerRepository.findDevelopersByLocationAndSpeciality(any())).thenReturn(Set.of());

        // when
        mockMvc.perform(get(DEVELOPER_PATH))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    void should_return_no_content_when_no_data_speciality() throws Exception {
        // given
        when(developerRepository.findAllDevelopersSpecialities()).thenReturn(Set.of());

        // when
        mockMvc.perform(get(DEVELOPER_SPECIALITY_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    void should_return_ok_developers_when_data_developer() throws Exception {
        // given
        when(developerRepository.findDevelopersByLocationAndSpeciality(any()))
                .thenReturn(Set.of(new Developer("veben", "France", "java", "")));

        // when
        mockMvc.perform(get(DEVELOPER_PATH))
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
}