package com.ex.ord.read;

import com.ex.ord.create.ApiTest;
import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Product;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.RequestProduct;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * fileName:ProductSelectTest
 * 작성날짜:2023-07-20
 * desc :
 **/


class ProductSelectTest extends ApiTest {

    @Autowired
    private ProductService productService; // 상품 등록 서버스

    @BeforeEach
    void setUp() {
    }

    private void 상품등록(){
        final String name = "노트북";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        RequestProduct request = new RequestProduct(name, price, discountPolicy); // 상품을 생성요청 하였고

        //Api = 요청 한다
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/products")
                .then().log().all().extract();
    }
    @Test
    void 상품조회()
    {
        // 등록
        상품등록();

        // 조회
        Long productId =1L;

        final Product product =  productService.getProudct(productId);

     ;
    }

   /* private class GetProductResponse {
    }*/
}