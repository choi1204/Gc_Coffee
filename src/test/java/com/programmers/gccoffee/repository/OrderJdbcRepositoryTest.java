package com.programmers.gccoffee.repository;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Order;
import com.programmers.gccoffee.model.entity.OrderItem;
import com.programmers.gccoffee.model.entity.Product;
import com.programmers.gccoffee.repository.OrderRepository;
import com.programmers.gccoffee.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class OrderJdbcRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    public void init() {
        String name = "test";
        Category category = Category.COFFEE;
        Long price = 1000L;
        String description = "설명";
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        Product saveProduct = new Product(name, category, price, description, now, now);
        productRepository.insert(saveProduct);
    }
    @Test
    @DisplayName("Order를 insert 할 수 있다.")
    public void _1() {
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = new OrderItem(1L, Category.DESERT, 1000L, 1);
        orderItemList.add(orderItem);
        String email = "gusdnd1204@naver.com";
        String address = "서울시";
        String postcode = "12345";
        Order order = new Order(email, address, postcode, orderItemList);
        Order insertOrder = orderRepository.insert(order);
        assertThat(insertOrder).usingRecursiveComparison().isEqualTo(order);
    }
}