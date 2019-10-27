package com.veben.microservices.order.ext.db;

import com.veben.microservices.order.domain.LineOrder;
import com.veben.microservices.order.domain.LineOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class JpaLineOrderRepository implements LineOrderRepository {

    private final EntityManager entityManager;

    @Override
    public List<LineOrder> findLineOrdersForOrder(String orderId) {
        String query = "select l from LineOrder l where l.parentOrder.id = :orderId";

        return new ArrayList<>(entityManager.createQuery(query, LineOrder.class)
                .setParameter("orderId", UUID.fromString(orderId))
                .getResultList());
    }
}
