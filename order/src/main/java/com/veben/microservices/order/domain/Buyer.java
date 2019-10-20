package com.veben.microservices.order.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@ToString
@Embeddable
public class Buyer {
    private String email;
    private String nom;
    private String prenom;

    @Embedded
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer that = (Buyer) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
