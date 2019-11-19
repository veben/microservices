package com.veben.microservices.developerinformation.ext.rest;

import com.veben.microservices.developerinformation.domain.DeveloperInformation;
import com.veben.microservices.developerinformation.domain.DeveloperInformationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DeveloperInformationController.class)
class DeveloperInformationControllerTest {

    private static final String DEVELOPER_INFORMATION_PATH = "/api/developer-information/v1/developer-informations/";

    @MockBean
    private DeveloperInformationRepository developerInformationRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_no_content_when_no_data_with_this_id() throws Exception {
        // given
        String developerId = "3bdfbba3-d472-4431-b9ac-c888e7505b8b";


        // when
        mockMvc.perform(get(DEVELOPER_INFORMATION_PATH + developerId))
                .andDo(MockMvcResultHandlers.print())
        // then
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    void should_return_ok_when_data_with_this_id() throws Exception {
        // given
        String developerId = "3bdfbba3-d472-4431-b9ac-c888e7505b8b";
        DeveloperInformation actualDeveloperInformation = DeveloperInformation.builder().developerId(developerId).build();
        when(developerInformationRepository.findInformationsFromDeveloperId(developerId))
                .thenReturn(Optional.of(actualDeveloperInformation));

        // when
        mockMvc.perform(get(DEVELOPER_INFORMATION_PATH + developerId))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk());
    }
}