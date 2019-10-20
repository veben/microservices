package com.veben.microservices.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@ToString
@Entity
@Table(name = "passed_order")
@StaticMetamodel(Order.class)
public class Order {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    LocalDateTime date;

    @Embedded
    private Buyer buyer;

    public Order(Buyer buyer, LocalDateTime date) {
        this.buyer = buyer;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
