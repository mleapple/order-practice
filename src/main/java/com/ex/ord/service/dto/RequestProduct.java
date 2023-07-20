package com.ex.ord.service.dto;

import com.ex.ord.entity.DiscountPolicy;

/**
 * fileName:RequestProduct
 * 작성날짜:2023-07-20
 * desc :
 **/
public class RequestProduct {
    private final String name;
    private final long price;
    private final DiscountPolicy discountPolicy;

    public RequestProduct(String name, long price, DiscountPolicy discountPolicy) {
        System.out.println(" 상품 생성요청= "  );
        this.name           = name;
        this.price          = price;
        this.discountPolicy = discountPolicy;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPoliy() {
        return discountPolicy;
    }
}
