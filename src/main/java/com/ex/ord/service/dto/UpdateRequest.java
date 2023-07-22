package com.ex.ord.service.dto;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Product;
import lombok.Data;

/**
 * fileName:UpdateRequest
 * 작성날짜:2023-07-21
 * desc :
 **/

@Data
public class UpdateRequest {

    private final Long productId;
    private final String name;
    private final long price;
    private final DiscountPolicy discountPolicy;

    public UpdateRequest(Long productId, String name, long price, DiscountPolicy discountPolicy) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public Long getProductId() {
        return productId;
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
