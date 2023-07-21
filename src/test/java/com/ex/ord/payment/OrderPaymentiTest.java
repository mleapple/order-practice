package com.ex.ord.payment;

import com.ex.ord.ProductStep;
import com.ex.ord.create.ApiTest;
import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Order;
import com.ex.ord.entity.Product;
import com.ex.ord.service.OrderService;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.OrderRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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
        ProductStep.주문생성요청(orderRequest);
        // 결제 테스트
    }

    @Test
    void 결제테스트(){
        // 상품이 있어야 주문을 하지
        // 주문이 있어야 결제를 하지
        Order order = new Order(new Product("자전거" ,5000, DiscountPolicy.NONE ) ,2); // 주문
        // 결제 하기
        final  PaymentRequest paymentRequest = new PaymentRequest(order , "1111-2222-3333-7777"); //결제 요청 객체
        PaymentService paymentService = new PaymentService();
        paymentService.createPayment(paymentRequest);
    }

    private class PaymentRequest {
        private final Order order;
        private final String cardnumber;

        public PaymentRequest(Order order, String cardnumber) {
            this.order = order;
            this.cardnumber = cardnumber;
        }

        public Order getOrder() {
            return order;
        }

        public String getCardnumber() {
            return cardnumber;
        }
    }

    private class PaymentService {
        public void createPayment(PaymentRequest paymentRequest) {
            PaymentPort paymentPort = new PaymentPort() {
                @Override
                public Order getOrder(Order order) {
                    return new Order(new Product("aaaa",1000,DiscountPolicy.FIX_10_AMOUNT ),2);// 주문정보 가져오기
                }

                @Override
                public void pay(Payment payment) {
                    System.out.println(" = PG 결제 하기 ");
                }

                @Override
                public void save(Payment payment) {
                    System.out.println(" = 결제 정보 저장하기 ");
                }
            };
            final Order order       = paymentPort.getOrder(paymentRequest.getOrder()); // 주문 아이디 체크
            final Payment payment   = new Payment(order,paymentRequest.getCardnumber()); // 결제 생성

            paymentPort.pay(payment); // 결제 모듈
            paymentPort.save(payment); // 결제 정보 저장
        }
    }

    private interface PaymentPort {

        Order getOrder(Order order);

        void pay(Payment payment);

        void save(Payment payment);
    }

    private class Payment {

        private final Order order;
        private final String cardnumber;

        public Payment(Order order, String cardnumber) {
            this.order = order;
            this.cardnumber = cardnumber;
        }
    }
}