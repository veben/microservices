package com.veben.microservices.developer.ext.client;

import com.veben.microservices.developer.ext.client.dto.DeveloperInformationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeveloperInformationService {

    @Value("${developer-information.host}")
    private String host;

    private final RestTemplate restTemplate;

    public Optional<DeveloperInformationDto> getDeveloperInformationById(@PathVariable String developerId) {
        String url = "http://" + host + ":8092/api/developer-information/v1/developer-informations/" + developerId;
        log.info("getDeveloperInformationById called on {}", url);

        DeveloperInformationDto result;

        try {
            result = restTemplate.getForObject(url, DeveloperInformationDto.class);
        } catch (Exception e) {
            log.warn("call on {} has failed => {}", url, e.getMessage());
            throw e;
        }
        return Optional.ofNullable(result);
    }
}