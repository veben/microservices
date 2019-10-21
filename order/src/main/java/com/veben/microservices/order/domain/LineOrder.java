package com.veben.microservices.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

import static lombok.AccessLevel.NONE;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "line_order")
public class LineOrder {

    @Id
    @Setter(NONE)
    private UUID id;

    private String product;

    private int number;

    @ManyToOne
    private Order parentOrder;

    protected LineOrder() {
        this.id = UUID.randomUUID();
    }

    public LineOrder(String product, int number) {
        this();
        this.product = product;
        this.number = number;
    }
}
