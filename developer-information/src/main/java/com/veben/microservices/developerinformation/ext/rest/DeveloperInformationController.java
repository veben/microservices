package com.veben.microservices.developerinformation.ext.rest;

import com.veben.microservices.developerinformation.domain.DeveloperInformation;
import com.veben.microservices.developerinformation.domain.DeveloperInformationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/developer-information/v1")
@Api(value = "developer-information")
@Slf4j
public class DeveloperInformationController {

    private final DeveloperInformationRepository developerInformationRepository;

    @GetMapping(value = "/developer-informations")
    @ApiOperation(value = "List developer informations", response = DeveloperInformation.class, responseContainer = "ResponseEntity")
    public ResponseEntity<Set<DeveloperInformation>> findAllDeveloperInformations() {
        log.info("findAllDeveloperInformations called");

        final Set<DeveloperInformation> developerInformations = developerInformationRepository.findAllInformations();

        return developerInformations.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(developerInformations);
    }

    @GetMapping(value = "/developer-informations/{developerId}")
    @ApiOperation(value = "Get developer informations for a developer", response = DeveloperInformation.class, responseContainer = "ResponseEntity")
    public ResponseEntity<DeveloperInformation> findDeveloperInformationForDeveloper(@PathVariable("developerId") String developerId) {
        log.info("findDeveloperInformationForDeveloper called with params: " + developerId);

        return developerInformationRepository.findInformationsFromDeveloperId(developerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }
}
