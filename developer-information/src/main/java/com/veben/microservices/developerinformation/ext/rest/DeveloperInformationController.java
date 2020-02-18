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

    static final String DEVELOPER_INFORMATION_URI = BASE_URI + "/developer-informations";
    private static final String DEVELOPER_INFORMATION_FOR_DEV_URI = DEVELOPER_INFORMATION_URI + "/{developerId}";

    @NonNull
    private final DeveloperInformationRepository developerInformationRepository;

    @GetMapping(DEVELOPER_INFORMATION_URI)
    @ApiOperation(value = "List all developer's information",
            response = DeveloperInformation.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<Set<DeveloperInformation>> findAllDeveloperInformations() {
        log.info("findAllDeveloperInformations called");

        return ResponseEntity.ok(developerInformationRepository.findAllInformations());
    }

    @GetMapping(DEVELOPER_INFORMATION_FOR_DEV_URI)
    @ApiOperation(value = "Get developer's information for a developer",
            response = DeveloperInformation.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<DeveloperInformation> findDeveloperInformationForDeveloper(@PathVariable("developerId") String developerId) {
        log.info("findDeveloperInformationForDeveloper called with params: " + developerId);

        return ResponseEntity.ok(developerInformationRepository.findDeveloperInformation(developerId));
    }
}
