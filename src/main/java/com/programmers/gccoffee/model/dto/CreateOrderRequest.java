package com.programmers.gccoffee.model.dto;

import com.programmers.gccoffee.model.entity.Order;
import com.programmers.gccoffee.model.entity.OrderItem;

import java.util.List;

public record CreateOrderRequest(String email, String address, String postcode, List<OrderItem> orderItems
) {
    public Order toOrder() {
        return new Order(email, address, postcode, orderItems);
    }
}