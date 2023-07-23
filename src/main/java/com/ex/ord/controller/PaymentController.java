package com.ex.ord.controller;

import com.ex.ord.service.PaymentService;
import com.ex.ord.service.dto.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * fileName:PaymentController
 * 작성날짜:2023-07-22
 * desc :
 **/
@RequestMapping("/payments")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createPayment(@RequestBody PaymentRequest paymentRequest){
        paymentService.createPayment(paymentRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
