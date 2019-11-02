package com.veben.microservices.developerinformation.domain;

import java.util.Optional;
import java.util.Set;

public interface DeveloperInformationRepository {

    Optional<DeveloperInformation> findInformationsFromDeveloperId(String developerId);

    Set<DeveloperInformation> findAllInformations();
}
