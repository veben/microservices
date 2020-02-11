package com.veben.microservices.developerinformation.ext.rest;

import com.veben.microservices.developerinformation.domain.DeveloperInformation;
import com.veben.microservices.developerinformation.domain.DeveloperInformationRepository;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DeveloperInformationController extends BaseController {

    private static final String DEVELOPER_INFORMATIONS_URI = BASE_URI + "/developer-informations";

    @NonNull
    private final DeveloperInformationRepository developerInformationRepository;

    @GetMapping(DEVELOPER_INFORMATIONS_URI)
    @ApiOperation(value = "List developer informations",
            response = DeveloperInformation.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<Set<DeveloperInformation>> findAllDeveloperInformations() {
        log.info("findAllDeveloperInformations called");

        final Set<DeveloperInformation> developerInformations = developerInformationRepository.findAllInformations();

        return developerInformations.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(developerInformations);
    }

    @GetMapping(DEVELOPER_INFORMATIONS_URI + "/{developerId}")
    @ApiOperation(value = "Get developer informations for a developer",
            response = DeveloperInformation.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<DeveloperInformation> findDeveloperInformationForDeveloper(@PathVariable("developerId") String developerId) {
        log.info("findDeveloperInformationForDeveloper called with params: " + developerId);

        return developerInformationRepository.findInformationsFromDeveloperId(developerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }
}
