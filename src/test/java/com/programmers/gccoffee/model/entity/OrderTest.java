package com.programmers.gccoffee.model.entity;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Order;
import com.programmers.gccoffee.model.entity.OrderItem;
import com.programmers.gccoffee.model.entity.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class OrderTest {

    @Test
    @DisplayName("모든 인자로 Order를 생성할 수 있다.")
    public void _1() {
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = new OrderItem(1L, Category.DESERT, 1000L, 1);
        orderItemList.add(orderItem);
        String email = "gusdnd1204@naver.com";
        String address = "서울시";
        String postcode = "12345";
        OrderStatus orderStatus = OrderStatus.ACCEPTED;
        LocalDateTime now = LocalDateTime.now();
        new Order(email, address, postcode, orderItemList, orderStatus, now, now);
    }

    @Test
    @DisplayName("날짜 인자를 주지않고 order를 만들수 있다.")
    public void _2() {
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = new OrderItem(1L, Category.DESERT, 1000L, 1);
        orderItemList.add(orderItem);
        String email = "gusdnd1204@naver.com";
        String address = "서울시";
        String postcode = "12345";
        OrderStatus orderStatus = OrderStatus.ACCEPTED;
        new Order(email, address, postcode, orderItemList, orderStatus);
    }

    @Test
    @DisplayName("날짜 인자와 orderState없이 order를 만들수 있다.")
    public void _3() {
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = new OrderItem(1L, Category.DESERT, 1000L, 1);
        orderItemList.add(orderItem);
        String email = "gusdnd1204@naver.com";
        String address = "서울시";
        String postcode = "12345";
        new Order(email, address, postcode, orderItemList);
    }
}