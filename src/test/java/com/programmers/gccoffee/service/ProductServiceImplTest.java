package com.programmers.gccoffee.service;

import com.programmers.gccoffee.exception.EntityNotFoundException;
import com.programmers.gccoffee.exception.ValidationException;
import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    static Product saveProduct;
    static String name;
    static Category category;
    static long price;
    static String description;

    @BeforeEach
    public void init() {
        productService.deleteAll();
        name = "test";
        category = Category.COFFEE;
        price = 1000L;
        description = "설명";
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        saveProduct = new Product(name, category, price, description, now, now);
        productService.save(saveProduct);
    }

    @Test
    @DisplayName("상품을 추가할 수 있다.")
    void _1() {
        String name = "Test";
        Category category = Category.COFFEE;
        long price = 1000L;
        String description = "설명";
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        Product product = new Product(name, category, price, description, now, now);
        productService.save(product);
        Product findProduct = productService.findByName("Test");
        assertThat(findProduct).usingRecursiveComparison().isEqualTo(product);
    }

    @Test
    @DisplayName("상품을 이름으로 조회할 수 있다.")
    void _2() {
        Product findProduct = productService.findByName(name);
        assertThat(findProduct).usingRecursiveComparison().isEqualTo(saveProduct);
    }

    @Test
    @DisplayName("상품을 상품아이디로 조회할 수 있다.")
    void _3() {
        Product product = productService.findById(4L);
        assertThat(product).usingRecursiveComparison().isEqualTo(saveProduct);
    }

    @Test
    @DisplayName("상품을 상품 카테고리으로 조회할 수 있다.")
    void _4() {
        List<Product> productList = productService.findByCategory(category);
        assertThat(productList).isNotEmpty();
        assertThat(productList).hasSize(1);
        Product product = productList.get(0);
        assertThat(product).usingRecursiveComparison().isEqualTo(saveProduct);
    }

    @Test
    @DisplayName("상품을 수정할 수 있다.")
    void _5() {
        saveProduct.setName("updated-Product");
        productService.update(saveProduct);

        Product findProduct = productService.findById(saveProduct.getId());
        assertThat(findProduct).usingRecursiveComparison().isEqualTo(saveProduct);
    }

    @Test
    @DisplayName("상품을 전체 삭제한다.")
    void _6() {
        productService.deleteAll();
        List<Product> productList = productService.findAll();
        assertThat(productList).isEmpty();
    }

    @Test
    @DisplayName("중복된 상품이름은 추가할 수 없다")
    void _7() {
        String name = "test";
        Category category = Category.COFFEE;
        long price = 1000L;
        String description = "설명";
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        Product product = new Product(name, category, price, description, now, now);
        assertThatThrownBy(() -> productService.save(product)).isInstanceOf(ValidationException.class);
    }

    @Test
    @DisplayName("없는 id로 조회할 수 없다.")
    void _8() {
        assertThatThrownBy(() ->  productService.findById(999L)).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("없는 이름으로 조회할 수 없다.")
    void _9() {
        assertThatThrownBy(() ->  productService.findByName("notFoundName")).isInstanceOf(EntityNotFoundException.class);
    }
}