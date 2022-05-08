package com.programmers.gccoffee.controller.api;

import com.programmers.gccoffee.model.dto.ProductFindResponse;
import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;
import com.programmers.gccoffee.model.dto.CreateProductRequest;
import com.programmers.gccoffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

//    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<ProductFindResponse>> productList(@RequestParam Optional<Category> category) {
        List<ProductFindResponse> productFindResponseList = category
                .map(productService::findByCategory)
                .orElse(productService.findAll())
                .stream().map(product -> ProductFindResponse.of(product))
                .collect(Collectors.toList());

        return ResponseEntity.ok(productFindResponseList);
    }

//    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{productId}")
    public ResponseEntity<ProductFindResponse> getProduct(@PathVariable Long productId) {
        Product product = productService.findById(productId);
        return ResponseEntity.ok(ProductFindResponse.of(product));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> newProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        Product saveProduct = productService.save(createProductRequest.toProduct());
        return ResponseEntity.created(URI.create("api/product/" + saveProduct.getId())).build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> productDelete(@PathVariable Long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
