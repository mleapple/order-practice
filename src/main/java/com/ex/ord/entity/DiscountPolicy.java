package com.ex.ord.entity;



/**
 * fileName:DiscountPoliy
 * 작성날짜:2023-07-20
 * desc :
 **/
public enum DiscountPolicy {
    NONE {
        @Override
        public long applyDiscount(final long price) { //
            return price;
        }

    },
    FIX_10_AMOUNT {
        @Override
        public long applyDiscount(final long price) { //

            return (long)(price * 0.9);
        }
    },
    FIX_20_AMOUNT {
        @Override
        public long applyDiscount(final long price) { //

            return (long)(price * 0.8);
        }
    };
    public abstract long applyDiscount(final long price);
}
