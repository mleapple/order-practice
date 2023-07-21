package com.ex.ord.repository;

import com.ex.ord.entity.Order;

/**
 * fileName:OrderPort
 * 작성날짜:2023-07-21
 * desc :
 **/
public interface OrderPort {
    void save(Order order);
}
