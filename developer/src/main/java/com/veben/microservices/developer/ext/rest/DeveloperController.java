package com.veben.microservices.developer.ext.rest;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperRepository;
import com.veben.microservices.developer.ext.client.DeveloperInformationService;
import com.veben.microservices.developer.ext.client.dto.DeveloperInformationDto;
import com.veben.microservices.developer.ext.rest.dto.DeveloperSearchDto;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DeveloperController extends BaseController {

    static final String DEVELOPERS_URI = BASE_URI + "/developers";
    static final String DEVELOPER_SPECIALITY_URI = DEVELOPERS_URI + "/list-specialities";
    private static final String DEVELOPER_INFORMATION_URI = DEVELOPERS_URI + "/{id}/developer-informations";

    @NonNull
    private final DeveloperRepository developerRepository;
    @NonNull
    private final DeveloperInformationService developerInformationService;

    @GetMapping(DEVELOPERS_URI)
    @ApiOperation(value = "List developers",
            response = Developer.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<Set<Developer>> findAllDevelopers(@Valid DeveloperSearchDto developerSearchDto) {
        log.info("findAllDevelopers called with params: " + developerSearchDto.toString());

        return ResponseEntity.ok(developerRepository
                .findDevelopersByLocationAndSpeciality(developerSearchDto.toDeveloperSearchCriteria()));
    }

    @GetMapping(DEVELOPER_SPECIALITY_URI)
    @ApiOperation(value = "List all developer specialities",
            response = String.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<Set<String>> findAllDevelopersSpecialities() {
        log.info("findAllDevelopersSpecialities called");

        return ResponseEntity.ok(developerRepository.findAllDevelopersSpecialities());
    }

    @GetMapping(DEVELOPER_INFORMATION_URI)
    @ApiOperation(value = "Get developer's information for a developer",
            response = DeveloperInformationDto.class,
            responseContainer = "ResponseEntity")
    public ResponseEntity<DeveloperInformationDto> findDeveloperInformationForDeveloper(@PathVariable("id") String id) {
        log.info("findDeveloperInformationForDeveloper called with params: " + id);

        return developerInformationService.getDeveloperInformationById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
