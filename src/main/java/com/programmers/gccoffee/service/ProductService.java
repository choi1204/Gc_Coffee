package com.programmers.gccoffee.service;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findByCategory(Category category);

    List<Product> findAll();

    Product save(Product product);

    Product findById(Long productId);

    Product findByName(String productName);

    Product update(Product product);

    void delete(Long productId);

    void deleteAll();
}
