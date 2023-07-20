package com.ex.ord.controller;

import com.ex.ord.entity.Product;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.RequestProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName:ProductController
 * 작성날짜:2023-07-20
 * desc :
 **/
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createProduct(@RequestBody final RequestProduct requestProduct){
        productService.creatProduct(requestProduct); // 메모리 저장하기
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
