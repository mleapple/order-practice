package com.ex.ord;

/**
 * fileName:RequestProduct
 * 작성날짜:2023-07-20
 * desc :
 **/
public class RequestProduct {
    private final String name;
    private final long price;
    private final DiscountPoliy discountPoliy;

    public RequestProduct(String name, long price, DiscountPoliy discountPoliy) {
        System.out.println(" 상품 생성요청= "  );
        this.name           = name;
        this.price          = price;
        this.discountPoliy  = discountPoliy;
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
}
