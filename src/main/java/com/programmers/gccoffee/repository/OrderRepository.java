package com.programmers.gccoffee.repository;

import com.programmers.gccoffee.model.entity.Order;

import java.util.List;

public interface OrderRepository {
    Order insert(Order order);
    List<Order> findAll();
}
