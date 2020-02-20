package com.veben.microservices.developerinformation.domain;

import java.util.Set;

public interface DeveloperInformationRepository {

    DeveloperInformation findDeveloperInformationForDeveloper(String developerId);

    Set<DeveloperInformation> findAllInformations();
}
