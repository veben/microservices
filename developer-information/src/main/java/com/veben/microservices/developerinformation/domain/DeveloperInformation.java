package com.veben.microservices.developerinformation.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

import static lombok.AccessLevel.NONE;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Document(collation = "developer-information")
public class DeveloperInformation {

    @Id
    @Setter(NONE)
    private UUID id;

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

    DeveloperInformation() {
        this.id = UUID.randomUUID();
    }

    @Builder
    public DeveloperInformation(
            String about, String websiteUrl, String stackOverflowUrl, String avatarUrl, int goldBadges, int silverBadges,
            int bronzeBadges, int reputation, String githubUrl, String name, String company, int publicRepositories, int followers) {
        this();

        this.about = about;
        this.websiteUrl = websiteUrl;
        this.stackOverflowUrl = stackOverflowUrl;
        this.avatarUrl = avatarUrl;
        this.goldBadges = goldBadges;
        this.silverBadges = silverBadges;
        this.bronzeBadges = bronzeBadges;
        this.reputation = reputation;
        this.githubUrl = githubUrl;
        this.name = name;
        this.company = company;
        this.publicRepositories = publicRepositories;
        this.followers = followers;
    }
}
