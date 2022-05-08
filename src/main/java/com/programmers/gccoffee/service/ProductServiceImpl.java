package com.programmers.gccoffee.service;

import com.programmers.gccoffee.exception.EntityNotFoundException;
import com.programmers.gccoffee.exception.ErrorCode;
import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;
import com.programmers.gccoffee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(ErrorCode.PRODUCT_NOT_FOUND_ID));
    }

    @Override
    public Product findByName(String productName) {
        return productRepository.findByName(productName).orElseThrow(() -> new EntityNotFoundException(ErrorCode.PRODUCT_NOT_FOUND_NAME));
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
