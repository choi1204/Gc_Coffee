package com.programmers.gccoffee.repository;

import com.programmers.gccoffee.model.entity.Order;
import com.programmers.gccoffee.model.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class OrderJdbcRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Order insert(Order order) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameter = new MapSqlParameterSource().addValues(toOrderParamMap(order));

        jdbcTemplate.update("INSERT INTO orders(email, address, postcode, order_status, created_at, updated_at) " +
                        "VALUES (:email, :address, :postcode, :orderStatus, :createdAt, :updatedAt) ",
                parameter, keyHolder);
        order.keyGeneration(keyHolder);
        order.getOrderItems().forEach(item ->
                jdbcTemplate.update(
                        "INSERT INTO order_items(order_id, product_id, category, price, quantity, created_at, updated_at) " +
                                "VALUES (:orderId, :productId, :category, :price, :quantity, :createdAt, :updatedAt)",
                        toOrderItemParamMap(order.getId(), order.getCreatedAt(), order.getUpdatedAt(), item)
                ));

        return order;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }


    private Map<String, Object> toOrderParamMap(Order order) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("orderId", order.getId());
        paramMap.put("email", order.getEmail());
        paramMap.put("address", order.getAddress());
        paramMap.put("postcode", order.getPostcode());
        paramMap.put("orderStatus", order.getOrderStatus().toString());
        paramMap.put("createdAt", order.getCreatedAt());
        paramMap.put("updatedAt", order.getUpdatedAt());
        return paramMap;
    }

    private Map<String, Object> toOrderItemParamMap(Long orderId, LocalDateTime createdAt, LocalDateTime updatedAt, OrderItem item) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("orderId", orderId);
        paramMap.put("productId", item.productId());
        paramMap.put("category", item.category().toString());
        paramMap.put("price", item.price());
        paramMap.put("quantity", item.quantity());
        paramMap.put("createdAt", createdAt);
        paramMap.put("updatedAt", updatedAt);
        return paramMap;
    }
    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
