package com.ex.ord.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * fileName:Order
 * 작성날짜:2023-07-21
 * desc :
 **/

@Entity
@Table(name = "order_tb")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private  Product product; // 상품
    private  int quantity; // 수량

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

