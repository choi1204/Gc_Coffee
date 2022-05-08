package com.programmers.gccoffee.model.entity;

import lombok.*;
import org.springframework.jdbc.support.KeyHolder;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Category category;
    private long price;
    private String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String name, Category category, long price, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String name, Category category, long price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Product(String name, Category category, long price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    public void keyGeneration(KeyHolder keyHolder) {
        this.id = keyHolder.getKey().longValue();
    }

}
