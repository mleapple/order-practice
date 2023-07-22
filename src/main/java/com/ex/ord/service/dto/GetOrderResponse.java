package com.ex.ord.service.dto;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Order;
import com.ex.ord.entity.Product;
import lombok.Data;

/**
 * fileName:GetProductResponse
 * 작성날짜:2023-07-20
 * desc :
 **/

@Data
public class GetOrderResponse {
    private final Long id;
    private final Order order;

    public GetOrderResponse(Long id, Order order) {
        this.id = id;
        this.order = order;
    }
}
