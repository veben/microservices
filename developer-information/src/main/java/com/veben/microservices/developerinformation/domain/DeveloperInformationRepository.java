package com.veben.microservices.developerinformation.domain;

import java.util.Set;

public interface DeveloperInformationRepository {

    DeveloperInformation findDeveloperInformation(String developerId);

    Set<DeveloperInformation> findAllInformations();
}
