package com.ex.ord.order;

import com.ex.ord.ProductStep;
import com.ex.ord.create.ApiTest;
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
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:ProductSelectTest
 * 작성날짜:2023-07-20
 * desc :
 **/

class ProductOrderApiTest extends ApiTest {

    @Autowired
    private ProductService productService; // 상품 등록 서버스

    @Autowired
    private OrderService orderService;

    @BeforeEach
    void setUp() {
    }
    @Test
    void 상품_주문_테스트()
    {
        // 등록
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
        // 주문요청
        orderService.createOrder(orderRequest);
    }

}