package com.ex.ord.entity;

import com.ex.ord.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * fileName:Payment
 * 작성날짜:2023-07-21
 * desc :
 **/
@Entity
@Table(name = "payment_tb")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private  Order order;
    private  String cardnumber;

    public Payment(Order order, String cardnumber) {
        this.order = order;
        this.cardnumber = cardnumber;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getCardnumber() {
        return cardnumber;
    }

}
