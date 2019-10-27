package com.veben.microservices.order.ext.db;

import com.veben.microservices.order.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class JpaOrderRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private JpaOrderRepository jpaOrderRepository;

    @Test
    void should_find_all_orders_when_data() {
        // given

        // when
        Set<Order> allOrders = jpaOrderRepository.findAllOrders();

        // then
        assertThat(allOrders).isNotEmpty();
    }
}