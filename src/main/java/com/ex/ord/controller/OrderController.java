package com.ex.ord.controller;

import com.ex.ord.entity.Order;
import com.ex.ord.entity.Product;
import com.ex.ord.service.OrderService;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.*;
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
@RequestMapping("/order")
public class OrderController {
    private final ProductService productService;

    private final OrderService orderService ;

    public OrderController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<GetOrderResponse> createOrder(@RequestBody final OrderRequest orderRequest){
        Order order = orderService.createOrder(orderRequest); // 메모리 저장하기
        final GetOrderResponse response   = new GetOrderResponse(order.getId() , order);
        return ResponseEntity.ok(response);


    }



}
