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
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/developer/v1")
@Api(value = "developer")
@Slf4j
public class DeveloperController {

    private static final String DEV_DATABASE_ERROR_MESSAGE = "Developer Database (PostgreSQL) is down!";
    private static final String DEV_INFO_DATABASE_ERROR_MESSAGE = "Developer Information Database (MongoDB) is down!";
    private static final String DEV_INFO_MS_ERROR_MESSAGE = "MS Developer Information is down!";
    private static final String UNHANDLED_ERROR_MESSAGE = "Unhandled error!";

    private final DeveloperRepository developerRepository;
    private final DeveloperInformationService developerInformationService;

    @GetMapping(value = "/developers")
    @ApiOperation(value = "List developers", response = Developer.class, responseContainer = "ResponseEntity")
    public ResponseEntity findAllDevelopers(@Valid DeveloperSearchDto developerSearchDto) {
        log.info("findAllDevelopers called with params: " + developerSearchDto.toString());

        final Set<Developer> developers;

        try {
            developers = developerRepository.findDevelopersByLocationAndSpeciality(developerSearchDto.toDeveloperSearchCriteria());
        } catch (DataAccessResourceFailureException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(DEV_DATABASE_ERROR_MESSAGE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(UNHANDLED_ERROR_MESSAGE);
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
        } catch (DataAccessResourceFailureException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(DEV_DATABASE_ERROR_MESSAGE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(UNHANDLED_ERROR_MESSAGE);
        }

        return developersSpecialities.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(developersSpecialities);
    }

    @GetMapping(value = "/developers/{id}/developer-informations")
    @ApiOperation(value = "Get developer informations for a developer", response = DeveloperInformationDto.class, responseContainer = "ResponseEntity")
    public ResponseEntity findDeveloperInformationForDeveloper(@PathVariable("id") String id) {
        log.info("findDeveloperInformationForDeveloper called with params: " + id);

        final Optional<DeveloperInformationDto> optionalDeveloperInformationDto;

        try {
            optionalDeveloperInformationDto = developerInformationService.getDeveloperInformationById(id);
        } catch (ResourceAccessException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(DEV_INFO_MS_ERROR_MESSAGE);
        } catch (HttpServerErrorException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(DEV_INFO_DATABASE_ERROR_MESSAGE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(UNHANDLED_ERROR_MESSAGE);
        }

        return optionalDeveloperInformationDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
