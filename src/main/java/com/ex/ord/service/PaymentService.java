package com.ex.ord.service;

import com.ex.ord.entity.Order;
import com.ex.ord.entity.Payment;
import com.ex.ord.repository.PaymentPort;
import com.ex.ord.service.dto.PaymentRequest;
import org.springframework.stereotype.Service;

/**
 * fileName:PaymentService
 * 작성날짜:2023-07-21
 * desc :
 **/
@Service
public class PaymentService {
   private final  PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void createPayment(PaymentRequest paymentRequest) {

        final Order order = paymentPort.getOrder(paymentRequest.getOrdid()); // 주문 아이디 체크
        final Payment payment = new Payment(order, paymentRequest.getCardnumber()); // 결제 생성

      // paymentPort.pay(payment); // 결제 모듈
        paymentPort.save(payment); // 결제 정보 저장
    }
}
