package com.programmers.gccoffee.model.entity;

public record OrderItem(Long productId, Category category, long price, int quantity) {

}
