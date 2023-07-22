package com.ex.ord.payment;

import com.ex.ord.ProductStep;
import com.ex.ord.create.ApiTest;
import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Order;
import com.ex.ord.entity.Product;
import com.ex.ord.service.OrderService;
import com.ex.ord.service.PaymentService;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.GetOrderResponse;
import com.ex.ord.service.dto.OrderRequest;
import com.ex.ord.service.dto.PaymentRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:ProductSelectTest
 * 작성날짜:2023-07-20
 * desc :
 **/

class OrderPaymentiTest extends ApiTest {

    @Autowired
    private ProductService productService; // 상품 등록 서버스
    @Autowired
    private OrderService orderService; // 주문 생성

    @Autowired
    PaymentService paymentService;

    @BeforeEach
    void setUp() {
    }
    @Test
    void 상품_주문_테스트()
    {// 등록
        ProductStep.상품등록();
        // 조회
        Long productId =1L;
        ExtractableResponse<Response> response = ProductStep.조회등록(productId);
        // 조회 검증
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("노트북");
        // 조회 상품 리턴
        Product product = response.body().as(Product.class);
        // 주문 생성
        final OrderRequest orderRequest = new OrderRequest(  product , 7);
        // 주문요청 API 요청
        ExtractableResponse<Response> orderResponse =  ProductStep.주문생성요청(orderRequest);
        assertThat(orderResponse.statusCode()).isEqualTo(HttpStatus.OK.value());

        System.out.println(orderResponse.body().jsonPath().getMap("order.product").get("name"));
        System.out.println(orderResponse.body().jsonPath().getMap("order.product").get("price"));
        System.out.println(orderResponse.body().jsonPath().getMap("order.product").get("discountPolicy"));
        // 결제
        final PaymentRequest paymentRequest = new PaymentRequest(orderResponse.body().jsonPath().getLong("id") , "1111-2222-3333-7777"); //결제 요청 객체

        paymentService.createPayment(paymentRequest);

       // System.out.println("getOrderResponse = " + orderResponse.body().jsonPath().getMap("product"));
      /*  GetOrderResponse getOrderResponse = orderResponse.body().as(GetOrderResponse.class);
        System.out.println("getOrderResponse = " + getOrderResponse);
        System.out.println("getOrderResponse = " + getOrderResponse.getId());*/
    }

    @Test
    void 결제테스트(){
        // 상품이 있어야 주문을 하지
        // 주문이 있어야 결제를 하지
/*        Order order = new Order(new Product("자전거" ,5000, DiscountPolicy.NONE ) ,2); // 주문
        // 결제 하기
        final  PaymentRequest paymentRequest = new PaymentRequest(order , "1111-2222-3333-7777"); //결제 요청 객체
        PaymentService paymentService = new PaymentService();
        paymentService.createPayment(paymentRequest);*/
    }

}