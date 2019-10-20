package com.veben.microservices.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany
    private List<LineOrder> lineOrders = new ArrayList<>();

    public Order(Buyer buyer, LocalDateTime date) {
        this.buyer = buyer;
        this.date = date;
    }

    public void addLineOrder(LineOrder lineOrder) {
        lineOrders.add(lineOrder);
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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<LineOrder> getLineOrders() {
        return lineOrders;
    }

    public void setLineOrders(List<LineOrder> lineOrders) {
        this.lineOrders = lineOrders;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
