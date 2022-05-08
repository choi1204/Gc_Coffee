package com.programmers.gccoffee.model.dto;

import com.programmers.gccoffee.model.entity.Product;

public record ProductFindResponse(
        Long productId,
        String productName,
        String category,
        Long price,
        String description)
{
    public static ProductFindResponse of(Product product) {
        return new ProductFindResponse(product.getId(), product.getName(), product.getCategory().toString(), product.getPrice(), product.getDescription());
    }
}
