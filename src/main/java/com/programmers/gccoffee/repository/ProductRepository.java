package com.programmers.gccoffee.repository;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Product insert(Product product);

    Product update(Product product);

    Optional<Product> findById(Long productId);

    Optional<Product> findByName(String productName);

    List<Product> findByCategory(Category category);

    void deleteAll();

    void deleteById(Long id);
}
