package com.veben.microservices.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Objects;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@ToString
@Entity
@Table(name = "line_order")
public class LineOrder {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String product;

    private int number;

    @ManyToOne
    private Order parentOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineOrder lineOrder = (LineOrder) o;
        return Objects.equals(id, lineOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public LineOrder(String product, int number) {
        this.product = product;
        this.number = number;
    }
}
