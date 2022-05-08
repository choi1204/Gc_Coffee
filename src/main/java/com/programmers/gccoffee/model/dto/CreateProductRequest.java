package com.programmers.gccoffee.model.dto;

import com.programmers.gccoffee.model.entity.Category;
import com.programmers.gccoffee.model.entity.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public record CreateProductRequest(
        @NotBlank(message = "제품명을 입력해주세요.")
        @Size(min = 1, max = 10, message= "제품명은 2글자에서 10글자 이내입니다.")
        String productName,

        Category category,

        @Positive(message = "가격은 양수값만 입력가능합니다.")
        @NotNull(message = "가격을 입력해주십시오.")
        Long price,

        @Size(max = 500, message = "설명의 최대길이는 500자 입니다.")
        String description) {

    public Product toProduct() {
        return new Product(productName, category, price, description);
    }
}

