package com.ex.ord.service.dto;

import com.ex.ord.entity.DiscountPolicy;

/**
 * fileName:GetProductResponse
 * 작성날짜:2023-07-20
 * desc :
 **/
public class GetProductResponse {
    private final Long id;
    private final String name;
    private final long price;
    private final DiscountPolicy discountPolicy;

    public GetProductResponse(Long id, String name, long price, DiscountPolicy discountPolicy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

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
}
