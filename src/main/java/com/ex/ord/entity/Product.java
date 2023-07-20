package com.ex.ord.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * fileName:Product
 * 작성날짜:2023-07-20
 * desc :
 **/
@Entity
@Table(name = "product_tb")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long price;
    private DiscountPoliy discountPoliy;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public DiscountPoliy getDiscountPoliy() {
        return discountPoliy;
    }

    public Product(String name, long price, DiscountPoliy discountPoliy) {
        this.name = name;
        this.price = price;
        this.discountPoliy = discountPoliy;
    }

    public void assignId(final Long id) {
        this.id = id;
    }
}
