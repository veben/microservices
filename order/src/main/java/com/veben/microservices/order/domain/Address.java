package com.veben.microservices.order.domain;

import lombok.*;

import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@ToString
@Embeddable
public class Address {
    private String country;
    private String city;
    private String street;
    private int number;
}
