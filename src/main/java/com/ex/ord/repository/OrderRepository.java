package com.ex.ord.repository;

import com.ex.ord.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * fileName:OrderRepository
 * 작성날짜:2023-07-21
 * desc :
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {
}
