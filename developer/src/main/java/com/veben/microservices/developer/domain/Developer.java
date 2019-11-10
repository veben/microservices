package com.veben.microservices.developer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import static lombok.AccessLevel.NONE;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @Setter(NONE)
    private UUID id;

    private String nickname;
    private String location;
    private String speciality;
    private String avatar;

    protected Developer() {
        this.id = UUID.randomUUID();
    }

    public Developer(String nickname, String location, String speciality, String avatar) {
        this();
        this.nickname = nickname;
        this.location = location;
        this.speciality = speciality;
        this.avatar = avatar;
    }
}
