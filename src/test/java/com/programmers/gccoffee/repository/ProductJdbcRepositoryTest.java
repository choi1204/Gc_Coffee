package com.programmers.gccoffee.repository;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;
import com.programmers.gccoffee.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
class ProductJdbcRepositoryTest {

    @Autowired
    ProductRepository repository;

    static Product saveProduct;
    static String name;
    static Category category;
    static long price;
    static String description;

    @BeforeEach
    public void init() {
        repository.deleteAll();
        name = "test";
        category = Category.COFFEE;
        price = 1000L;
        description = "설명";
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        saveProduct = new Product(name, category, price, description, now, now);
        repository.insert(saveProduct);
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
        repository.insert(product);
        Optional<Product> optionalProduct = repository.findByName("Test");
        productSameTest(optionalProduct, product);
    }

    @Test
    @DisplayName("상품을 이름으로 조회할 수 있다.")
    void _2() {
        Optional<Product> product = repository.findByName(name);
        productSameTest(product, saveProduct);
    }

    @Test
    @DisplayName("상품을 상품아이디로 조회할 수 있다.")
    void _3() {
        Optional<Product> product = repository.findById(4L);
        productSameTest(product, saveProduct);
    }

    @Test
    @DisplayName("상품을 상품 카테고리으로 조회할 수 있다.")
    void _4() {
        List<Product> productList = repository.findByCategory(category);
        assertThat(productList).isNotEmpty();
        assertThat(productList).hasSize(1);
        Optional<Product> product = Optional.ofNullable(productList.get(0));
        productSameTest(product, saveProduct);
    }

    @Test
    @DisplayName("상품을 수정할 수 있다.")
    void _5() {
        saveProduct.setName("updated-Product");
        repository.update(saveProduct);

        Product findProduct = repository.findById(saveProduct.getId()).get();
        assertThat(findProduct).usingRecursiveComparison().isEqualTo(saveProduct);
    }

    @Test
    @DisplayName("상품을 전체 삭제한다.")
    void _6() {
        repository.deleteAll();
        List<Product> productList = repository.findAll();
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
        assertThatThrownBy(() -> repository.insert(product)).isInstanceOf(RuntimeException.class);
    }
    private void productSameTest(Optional<Product> optionalProduct, Product product) {
        assertThat(optionalProduct).isNotEmpty();
        assertThat(optionalProduct.get()).usingRecursiveComparison().isEqualTo(product);
    }
}