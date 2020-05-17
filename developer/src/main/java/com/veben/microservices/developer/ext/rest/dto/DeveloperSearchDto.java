package com.veben.microservices.developer.ext.rest.dto;

import com.veben.microservices.developer.domain.DeveloperSearchCriteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeveloperSearchDto {
    private String nickname;
    private String location;
    private String speciality;

    public DeveloperSearchCriteria toDeveloperSearchCriteria() {
        return new DeveloperSearchCriteria()
                .nickname(nickname)
                .location(location)
                .speciality(speciality);
    }
}
