package com.ex.ord.update;

import com.ex.ord.ProductStep;
import com.ex.ord.create.ApiTest;
import com.ex.ord.entity.Product;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.UpdateRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:ProductSelectTest
 * 작성날짜:2023-07-20
 * desc :
 **/


class ProductUpdateApiTest extends ApiTest {

    @Autowired
    private ProductService productService; // 상품 등록 서버스

    @BeforeEach
    void setUp() {
    }


    @Test
    void 상품업데이트Api_테스트()
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
        // udpate   수정 정보
        final UpdateRequest reuqest = new UpdateRequest(product.getId() , "BMW" ,37100, product.getDiscountPolicy());
        final ExtractableResponse<Response> updateResponse = ProductStep.수정하기(reuqest);
        // 수정 검증
        assertThat(updateResponse.statusCode()).isEqualTo(HttpStatus.OK.value());
        // 수정 확인
        response = ProductStep.조회등록(productId);
        assertThat(response.jsonPath().getString("name")).isEqualTo("BMW");
    }
    
}