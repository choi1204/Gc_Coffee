package com.programmers.gccoffee.controller;

import com.programmers.gccoffee.model.dto.CreateProductRequest;
import com.programmers.gccoffee.model.dto.ProductFindResponse;
import com.programmers.gccoffee.model.entity.Product;
import com.programmers.gccoffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String redirectProductList(Model model) {
        List<ProductFindResponse> productList = productService.findAll().stream().map(product -> ProductFindResponse.of(product)).collect(Collectors.toList());
        model.addAttribute("productList",productList);
        return "productList";
    }

    @GetMapping("/{productId}")
    public String redirectProduct(Model model, @PathVariable Long productId) {
        model.addAttribute("product", ProductFindResponse.of(productService.findById(productId)));
        return "product";
    }


    @GetMapping("/create")
    public String redirectCreate() {
        return "CreateProduct";
    }
    @PostMapping("/create")
    public String createProduct(@Valid CreateProductRequest request) {
        Product product = request.toProduct();
        productService.save(product);
        return "redirect:/product";
    }

    @PostMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        return "redirect:/product";
    }



}
