package com.veben.microservices.developer.ext.rest;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperRepository;
import com.veben.microservices.developer.ext.rest.dto.DeveloperSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/developer/v1")
@Api(value = "developer")
@Slf4j
public class DeveloperController {

    private final DeveloperRepository developerRepository;

    @GetMapping(value = "/developers")
    @ApiOperation(value = "List developers", response = Developer.class, responseContainer = "ResponseEntity")
    public ResponseEntity<Set<Developer>> findAllDevelopers(@Valid DeveloperSearchDto developerSearchDto) {
        log.info("findAllDevelopers called with params: " + developerSearchDto.toString());

        final Set<Developer> developers = developerRepository
                .findDevelopersByLocationAndSpeciality(developerSearchDto.toDeveloperSearchCriteria());

        return developers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(developers);
    }

    @GetMapping(value = "/developers/list-specialities")
    @ApiOperation(value = "List all developer specialities", response = String.class, responseContainer = "ResponseEntity")
    public ResponseEntity<Set<String>> findAllDevelopersSpecialities() {
        log.info("findAllDevelopersSpecialities called");

        final Set<String> developersSpecialities = developerRepository.findAllDevelopersSpecialities();

        return developersSpecialities.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(developersSpecialities);
    }
}
