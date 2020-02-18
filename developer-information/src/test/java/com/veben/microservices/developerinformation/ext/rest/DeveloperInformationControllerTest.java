package com.veben.microservices.developerinformation.ext.rest;

import com.veben.microservices.developerinformation.domain.DeveloperInformation;
import com.veben.microservices.developerinformation.domain.DeveloperInformationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static com.veben.microservices.developerinformation.ext.rest.DeveloperInformationController.DEVELOPER_INFORMATION_URI;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeveloperInformationController.class)
class DeveloperInformationControllerTest {

    @MockBean
    private DeveloperInformationRepository developerInformationRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_ok_when_data_with_this_id() throws Exception {
        // given
        final var developerId = "3bdfbba3-d472-4431-b9ac-c888e7505b8b";
        when(developerInformationRepository.findDeveloperInformation(developerId))
                .thenReturn(DeveloperInformation
                        .builder()
                        .developerId(developerId)
                        .build());

        // when
        mockMvc.perform(get(DEVELOPER_INFORMATION_URI + "/" + developerId))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk());
    }
}