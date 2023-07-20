package com.ex.ord.controller;

import com.ex.ord.entity.Product;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.GetProductResponse;
import com.ex.ord.service.dto.RequestProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse>  getProducResponseEntity (@PathVariable("productId") long productId){
        Product proudct                     = productService.getProudct(productId);
        final GetProductResponse response   = new GetProductResponse(proudct.getId(), proudct.getName(), proudct.getPrice(), proudct.getDiscountPolicy());
        return ResponseEntity.ok(response);
    }
}
