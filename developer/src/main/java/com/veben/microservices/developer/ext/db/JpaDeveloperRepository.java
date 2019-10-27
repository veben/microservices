package com.veben.microservices.developer.ext.db;

import com.veben.microservices.developer.domain.Developer;
import com.veben.microservices.developer.domain.DeveloperRepository;
import com.veben.microservices.developer.domain.DeveloperSearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface JpaDeveloperRepository extends DeveloperRepository, JpaRepository<Developer, UUID> {

    /********************* JPA *********************/
    @Query(value = "select speciality from Developer")
    List<String> findAllSpecialities();

    @Query("select d from Developer d" +
            " where (?1 is null or lower(d.nickname) like concat('%', lower(cast(?1 as string)), '%'))" +
            " and (?2 is null or lower(d.location) like concat('%', lower(cast(?2 as string)), '%'))" +
            " and (?3 is null or lower(d.speciality) like concat('%', lower(cast(?3 as string)), '%'))")
    List<Developer> findDevelopersWithSimilarLocationAndSimilarSpeciality(String nickname, String location, String speciality);

    /********************* JPA *********************/

    @Override
    default Set<String> findAllDevelopersSpecialities() {
        return new HashSet<>(findAllSpecialities());
    }

    @Override
    default Set<Developer> findDevelopersByLocationAndSpeciality(DeveloperSearchCriteria developerSearchCriteria) {
        return new HashSet<>(this.findDevelopersWithSimilarLocationAndSimilarSpeciality(
                developerSearchCriteria.nickname(),
                developerSearchCriteria.location(),
                developerSearchCriteria.speciality()));
    }
}
