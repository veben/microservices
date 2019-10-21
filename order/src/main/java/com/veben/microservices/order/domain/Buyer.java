package com.veben.microservices.order.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@ToString
@EqualsAndHashCode(of = "email")
@AllArgsConstructor
@Embeddable
public class Buyer {
    private String email;
    private String name;
    private String surname;

    @Embedded
    private Address address;
}
