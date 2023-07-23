package com.ex.ord.payment;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Order;
import com.ex.ord.entity.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:DiscountPolicyTest
 * 작성날짜:2023-07-23
 * desc :
 **/
public class DiscountPolicyTest {

    @Test
    void none_할인율없음(){
        final long price = 70000;
        final long discountedPrice = DiscountPolicy.NONE.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(70000);
    }

    @Test
    void none_할인율10프로(){
        final long price = 1000;
        final long discountedPrice = DiscountPolicy.FIX_10_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(900);
    }


    @Test
    void none_할인율20프로(){
        final long price = 1000;
        final long discountedPrice = DiscountPolicy.FIX_10_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(800);
    }
    @Test
    void getTotalPrice() {
        final Order order       = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_10_AMOUNT), 1);
        final int totalPrice    = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(1800);
    }
}
