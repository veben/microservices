package com.veben.microservices.developerinformation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static lombok.AccessLevel.NONE;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Document(collection = "developer-information")
public class DeveloperInformation {

    @Id
    @Setter(NONE)
    @JsonIgnore
    private ObjectId id;

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

    protected DeveloperInformation() {
        this.id = ObjectId.get();
    }

    @Builder
    public DeveloperInformation(
            String developerId, String about, String websiteUrl, String stackOverflowUrl, String avatarUrl,
            int goldBadges, int silverBadges, int bronzeBadges, int reputation, String githubUrl, String name,
            String company, int publicRepositories, int followers) {
        this();

        this.developerId = developerId;
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
