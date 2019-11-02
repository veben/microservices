package com.veben.microservices.developer.ext.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeveloperInformationDto {
    private String developerId;
    private String about;
    private String websiteUrl;
    private String stackOverflowUrl;
    private String avatarUrl;
    private int goldBadges;
    private int silverBadges;
    private int bronzeBadges;
    private int reputation;
    private String githubUrl;
    private String name;
    private String company;
    private int publicRepositories;
    private int followers;
}
