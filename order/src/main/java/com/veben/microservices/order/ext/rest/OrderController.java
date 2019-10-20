package com.veben.microservices.order.ext.rest;

import com.veben.microservices.order.domain.LineOrder;
import com.veben.microservices.order.domain.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/order/v1")
@Api(value = "order")
@Slf4j
public class OrderController {

    @GetMapping(value = "/orders")
    @ApiOperation(value = "List orders", response = Order.class, responseContainer = "ResponseEntity")
    public ResponseEntity<Set<Order>> findAllOrders() {
        log.info("findAllOrders called");

        // TODO Change after service & repo creation
        final Set<Order> orders = Set.of();

        return orders.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(orders);
    }

    @GetMapping(value = "/orders/{id}/line-orders")
    @ApiOperation(value = "List lines for an order", response = Order.class, responseContainer = "ResponseEntity")
    public ResponseEntity<List<LineOrder>> findLineOrdersForOrder(@PathVariable("id") String id) {
        log.info("findLineOrdersForOrder called with params: " + id);

        // TODO Change after service & repo creation
        final List<LineOrder> lineOrders = List.of();

        return lineOrders.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lineOrders);
    }
}
