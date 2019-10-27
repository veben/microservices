package com.veben.microservices.developer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Setter
@ToString
public class DeveloperSearchCriteria {
    private String nickname;
    private String location;
    private String speciality;
}
