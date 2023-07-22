package com.ex.ord.service;

import com.ex.ord.entity.Order;
import com.ex.ord.repository.OrderPort;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.service.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalLong;

/**
 * fileName:OrderService
 * 작성날짜:2023-07-21
 * desc :
 **/
@Service
public class OrderService {
    private final ProductPort productPort;
    private final OrderPort orderPort;

    public OrderService(@Qualifier("productBeanAdapter") ProductPort productPort, OrderPort orderPort) {
        this.productPort = productPort;
        this.orderPort = orderPort;
    }

    public Order createOrder(OrderRequest orderRequest) {
        // 주문 상품 확인 하기
        OptionalLong id = OptionalLong.of(orderRequest.getProduct().getId());
        if (Optional.of(productPort.getProudct(id.getAsLong())).isPresent()) { // 상품이 조
            // 주문생성
           final Order order = new Order(orderRequest.getProduct(), orderRequest.getQuantity());
           return  orderPort.save(order);
        }
        return null;

    }
}
