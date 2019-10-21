package com.veben.microservices.order.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final LineOrderRepository lineOrderRepository;

    @Transactional(readOnly = true)
    public Set<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Transactional(readOnly = true)
    public List<LineOrder> findLineOrdersForOrder(String orderId) {
        return lineOrderRepository.findLineOrdersForOrder(orderId);
    }
}
