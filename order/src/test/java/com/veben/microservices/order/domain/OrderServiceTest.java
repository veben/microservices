package com.veben.microservices.order.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private LineOrderRepository lineOrderRepository;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderRepository, lineOrderRepository);
    }

    @Test
    void should_find_all_orders_when_data() {
        // given
        var order = new Order(
                new Buyer(
                        "jean-michel@gmail.com", "Dupont", "Jean-Michel",
                        new Address("France", "Paris", "Lombard", 10)),
                now());
        when(orderRepository.findAllOrders()).thenReturn(Set.of(order));

        // then
        Set<Order> actualOrders = orderService.findAllOrders();

        // then
        assertThat(actualOrders).containsExactly(order);
    }

    @Test
    void should_find_line_orders_for_order_when_data() {
        // given
        String orderId = "id";
        var lineOrder = new LineOrder("Bike", 1);
        when(lineOrderRepository.findLineOrdersForOrder(orderId)).thenReturn(List.of(lineOrder));

        // then
        List<LineOrder> actualLineOrders = orderService.findLineOrdersForOrder(orderId);

        // then
        assertThat(actualLineOrders).containsExactly(lineOrder);
    }
}