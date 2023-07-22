package com.ex.ord.repository;

import com.ex.ord.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName:PaymentRepository
 * 작성날짜:2023-07-21
 * desc :
 **/
public interface PaymentRepository extends JpaRepository<Payment,Long>  {
}
