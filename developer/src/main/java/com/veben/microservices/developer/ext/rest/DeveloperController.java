package com.veben.microservices.developer.ext.rest;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperRepository;
import com.veben.microservices.developer.ext.client.DeveloperInformationService;
import com.veben.microservices.developer.ext.client.dto.DeveloperInformationDto;
import com.veben.microservices.developer.ext.rest.dto.DeveloperSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/developer/v1")
@Api(value = "developer")
@Slf4j
public class DeveloperController {

    private static final String DATABASE_ERROR_MESSAGE = "Developer Database down";

    private final DeveloperRepository developerRepository;
    private final DeveloperInformationService developerInformationService;

    @GetMapping(value = "/developers")
    @ApiOperation(value = "List developers", response = Developer.class, responseContainer = "ResponseEntity")
    public ResponseEntity findAllDevelopers(@Valid DeveloperSearchDto developerSearchDto) {
        log.info("findAllDevelopers called with params: " + developerSearchDto.toString());

        final Set<Developer> developers;

        try {
            developers = developerRepository.findDevelopersByLocationAndSpeciality(developerSearchDto.toDeveloperSearchCriteria());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(DATABASE_ERROR_MESSAGE);
        }

        return developers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(developers);
    }

    @GetMapping(value = "/developers/list-specialities")
    @ApiOperation(value = "List all developer specialities", response = String.class, responseContainer = "ResponseEntity")
    public ResponseEntity findAllDevelopersSpecialities() {
        log.info("findAllDevelopersSpecialities called");

        final Set<String> developersSpecialities;

        try {
            developersSpecialities = developerRepository.findAllDevelopersSpecialities();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(DATABASE_ERROR_MESSAGE);
        }

        return developersSpecialities.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(developersSpecialities);
    }

    @GetMapping(value = "/developers/{id}/developer-informations")
    @ApiOperation(value = "Get developer informations for a developer", response = DeveloperInformationDto.class, responseContainer = "ResponseEntity")
    public ResponseEntity<DeveloperInformationDto> findDeveloperInformationForDeveloper(@PathVariable("id") String id) {
        log.info("findDeveloperInformationForDeveloper called with params: " + id);

        return developerInformationService.getDeveloperInformationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
