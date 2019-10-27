package com.veben.microservices.order.ext.db;

import com.veben.microservices.order.domain.LineOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JpaLineOrderRepositoryTest  extends AbstractRepositoryTest {

    @Autowired
    private JpaLineOrderRepository jpaLineOrderRepository;

    @Test
    void should_find_line_orders_for_existing_order() {
        // given
        String orderId = "c5a659c3-5ba1-42bb-b1fb-b35d4f589f34";

        // when
        List<LineOrder> lineOrders = jpaLineOrderRepository.findLineOrdersForOrder(orderId);

        // then
        assertThat(lineOrders).isNotEmpty();
    }
}