package com.veben.microservices.order.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final LineOrderRepository lineOrderRepository;

    public Set<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    public List<LineOrder> findLineOrdersForOrder(String orderId) {
        return lineOrderRepository.findLineOrdersForOrder(orderId);
    }
}
