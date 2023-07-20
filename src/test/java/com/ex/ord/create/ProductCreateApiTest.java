package com.ex.ord.create;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.service.dto.RequestProduct;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:ProductCrateTest
 * 작성날짜:2023-07-20
 * desc :
 **/


class ProductCreateApiTest extends ApiTest {
    @Test
    void 상품생성하기_API(){

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

       // 응답코드 201
       assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

}