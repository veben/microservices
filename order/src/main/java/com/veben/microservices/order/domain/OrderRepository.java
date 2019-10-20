package com.veben.microservices.order.domain;

import java.util.Set;

public interface OrderRepository {
    Set<Order> findAllOrders();
}
