package com.veben.microservices.developer.domain;

import java.util.Set;

public interface DeveloperRepository {

    Set<String> findAllDevelopersSpecialities();

    Set<Developer> findDevelopersByLocationAndSpeciality(DeveloperSearchCriteria developerSearchCriteria);
}