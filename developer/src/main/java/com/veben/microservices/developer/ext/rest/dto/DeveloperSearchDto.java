package com.veben.microservices.developer.ext.rest.dto;

import com.veben.microservices.developer.domain.DeveloperSearchCriteria;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeveloperSearchDto {
    @ApiParam(value = "Developer nickname")
    private String nickname;

    @ApiParam(value = "Developer location")
    private String location;

    @ApiParam(value = "Developer speciality")
    private String speciality;

    public DeveloperSearchCriteria toDeveloperSearchCriteria() {
        return new DeveloperSearchCriteria()
                .nickname(nickname)
                .location(location)
                .speciality(speciality);
    }
}
