package com.ex.ord.entity;

/**
 * fileName:Product
 * 작성날짜:2023-07-20
 * desc :
 **/
public class Product {
    private Long id;
    private final String name;
    private final long price;
    private final DiscountPoliy discountPoliy;


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
