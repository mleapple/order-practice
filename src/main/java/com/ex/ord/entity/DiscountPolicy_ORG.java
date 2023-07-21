package com.ex.ord.entity;

/**
 * fileName:DiscountPoliy
 * 작성날짜:2023-07-20
 * desc :
 **/
public enum DiscountPolicy_ORG {
    NONE(0),DC10(10) ,DC20(20),DC30(30);
    private int discount ;
    public int getDiscount() {
        return discount;
    }
    DiscountPolicy_ORG(int discount) {
     this.discount = discount;
    }
}
