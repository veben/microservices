package com.veben.microservices.developerinformation.ext.db;

import com.veben.microservices.developerinformation.domain.DeveloperInformation;
import com.veben.microservices.developerinformation.domain.DeveloperInformationRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public interface JpaDeveloperInformationRepository extends
        DeveloperInformationRepository,
        MongoRepository<DeveloperInformation, ObjectId> {

    @Override
    default Set<DeveloperInformation> findAllInformations() {
        return new HashSet<>(findAll());
    }

    @Override
    default DeveloperInformation findDeveloperInformationForDeveloper(String developerId) {
        return findDeveloperInformationByDeveloperId(developerId);
    }

    DeveloperInformation findDeveloperInformationByDeveloperId(String developerId);
}
