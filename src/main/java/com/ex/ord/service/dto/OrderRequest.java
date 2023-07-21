package com.ex.ord.service.dto;

import com.ex.ord.entity.Product;

/**
 * fileName:OrderRequest
 * 작성날짜:2023-07-21
 * desc :
 **/
public class OrderRequest {
    private final Product product;
    private final int quantity;

    public OrderRequest(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
