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
    private DiscountPolicy discountPolicy;
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public Product(String name, long price, DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void  update(final String name, final long price, final DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }


    public void assignId( Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountPolicy=" + discountPolicy +
                '}';
    }

    public  Long getDiscountPrice(){ // 할인율
        return discountPolicy.applyDiscount(price);
    }
}
