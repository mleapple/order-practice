package com.ex.ord.repository;

import com.ex.ord.entity.Order;
import com.ex.ord.entity.Payment;

/**
 * fileName:PaymentPort
 * 작성날짜:2023-07-21
 * desc :
 **/
public interface PaymentPort {

    Order getOrder(final long ordIdr);

    void pay(Payment payment);

    void save(Payment payment);
}
