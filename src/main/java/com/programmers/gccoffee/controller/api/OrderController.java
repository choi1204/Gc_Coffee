package com.programmers.gccoffee.controller.api;

import com.programmers.gccoffee.model.dto.CreateOrderRequest;
import com.programmers.gccoffee.model.entity.Order;
import com.programmers.gccoffee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public Order saveOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest) {
        Order order = createOrderRequest.toOrder();
        return orderService.save(order);
    }

}
