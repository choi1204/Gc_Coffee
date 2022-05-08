package com.programmers.gccoffee.model.entity;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    @DisplayName("모든 인자를 통해 Product를 생성할 수 있다.")
    public void _1() {
        long id = 1L;
        String name = "test";
        Category category = Category.COFFEE;
        long price = 1000L;
        String description = "설명";
        LocalDateTime now =LocalDateTime.now();
        Product product = new Product(id, name, category, price, description, now, now);
        assertThat(product.getId()).isEqualTo(id);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getCategory()).isEqualTo(category);
        assertThat(product.getPrice()).isEqualTo(price);
        assertThat(product.getDescription()).isEqualTo(description);
        assertThat(product.getCreatedAt()).isEqualTo(now);
        assertThat(product.getUpdatedAt()).isEqualTo(now);
    }

    @Test
    @DisplayName("Id컬럼 없이 Product를 생성할 수 있다.")
    public void _2() {
        String name = "test";
        Category category = Category.COFFEE;
        long price = 1000L;
        String description = "설명";
        LocalDateTime now =LocalDateTime.now();
        Product product = new Product(name, category, price, description, now, now);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getCategory()).isEqualTo(category);
        assertThat(product.getPrice()).isEqualTo(price);
        assertThat(product.getDescription()).isEqualTo(description);
        assertThat(product.getCreatedAt()).isEqualTo(now);
        assertThat(product.getUpdatedAt()).isEqualTo(now);
    }

    @Test
    @DisplayName("ID, CreatedAt, UpdatedAt 없이 Product를 생성할 수 있다")
    public void _3() {
        String name = "test";
        Category category = Category.COFFEE;
        long price = 1000L;
        String description = "설명";
        Product product = new Product(name, category, price, description);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getCategory()).isEqualTo(category);
        assertThat(product.getPrice()).isEqualTo(price);
        assertThat(product.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("ID, CreatedAt, UpdatedAt, Description 없이 Product를 생성할 수 있다")
    public void _4() {
        String name = "test";
        Category category = Category.COFFEE;
        long price = 1000L;
        Product product = new Product(name, category, price);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getCategory()).isEqualTo(category);
        assertThat(product.getPrice()).isEqualTo(price);
    }

    @Test
    @DisplayName("이름을 변경할 수 있다.")
    public void _5() {
        Product product = getProduct();
        String updateName = "update";
        product.setName(updateName);
        assertThat(product.getName()).isEqualTo(updateName);
    }

    @Test
    @DisplayName("카테고리를 변경할 수 있다.")
    public void _6() {
        Product product = getProduct();
        Category category = Category.DESERT;
        product.setCategory(category);
        assertThat(product.getCategory()).isEqualTo(category);
    }

    @Test
    @DisplayName("가격을 변경할 수 있다.")
    public void _7() {
        Product product = getProduct();
        Long price = 20L;
        product.setPrice(price);
        assertThat(product.getPrice()).isEqualTo(price);
    }

    @Test
    @DisplayName("설명을 바꿀 수 있다.")
    public void _8() {
        Product product = getProduct();
        String description = "update";
        product.setDescription(description);
        assertThat(product.getDescription()).isEqualTo(description);
    }

    private Product getProduct() {
        String name = "test";
        Category category = Category.COFFEE;
        long price = 1000L;
        Product product = new Product(name, category, price);
        return product;
    }
}