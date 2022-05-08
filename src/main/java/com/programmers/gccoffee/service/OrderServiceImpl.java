package com.programmers.gccoffee.service;

import com.programmers.gccoffee.model.entity.Order;
import com.programmers.gccoffee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.insert(order);
    }
}
