package com.ex.ord.adapter;

import com.ex.ord.entity.Order;
import com.ex.ord.repository.OrderPort;
import com.ex.ord.repository.OrderRepository;
import org.springframework.stereotype.Component;

/**
 * fileName:OrderAdapter
 * 작성날짜:2023-07-21
 * desc :
 **/
@Component
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;

    public OrderAdapter(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
         return  orderRepository.save(order);
    }
}
