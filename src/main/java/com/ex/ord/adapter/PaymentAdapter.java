package com.ex.ord.adapter;

import com.ex.ord.entity.Order;
import com.ex.ord.entity.Payment;
import com.ex.ord.repository.OrderPort;
import com.ex.ord.repository.OrderRepository;
import com.ex.ord.repository.PaymentPort;
import com.ex.ord.repository.PaymentRepository;
import com.ex.ord.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * fileName:PaymentAdapter
 * 작성날짜:2023-07-21
 * desc :
 **/
@Component
@Qualifier("paymentAdapter")
public class PaymentAdapter implements PaymentPort {
    private final OrderRepository orderRepository;

    private final PaymentRepository paymentRepository;

    public PaymentAdapter(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(final long ordId) {
        return  orderRepository.findById(ordId).orElseThrow(()->new IllegalArgumentException());
    }
    @Override
    public void pay(final Payment payment) {
        // 결제하기
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
