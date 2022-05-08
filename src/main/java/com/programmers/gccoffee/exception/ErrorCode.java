package com.programmers.gccoffee.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "COM-001", "잘못된 데이터를 입력하였습니다."),

    PRODUCT_NOT_FOUND_ID(404, "PRODUCT-001", "없는 Product ID 입니다."),
    PRODUCT_NOT_FOUND_NAME(404, "PRODUCT-002", "없는 Product Name 입니다."),
    PRODUCT_VALIDATION_ID(400, "PRODUCT-003", "중복된 아이디 입니다.");

    private final int status;
    private final String codeName;
    private final String message;
}
