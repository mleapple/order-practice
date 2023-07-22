package com.ex.ord.service.dto;

import com.ex.ord.entity.Order;
import lombok.Data;

/**
 * fileName:PaymentRequest
 * 작성날짜:2023-07-21
 * desc :
 **/
@Data
public class PaymentRequest {
    private final long ordid;
    private final String cardnumber;
    public PaymentRequest(long ordid, String cardnumber) {
        this.ordid = ordid;
        this.cardnumber = cardnumber;
    }
}
