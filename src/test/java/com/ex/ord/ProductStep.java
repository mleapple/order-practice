package com.ex.ord;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.service.dto.RequestProduct;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

/**
 * fileName:ProductStep
 * 작성날짜:2023-07-20
 * desc :
 **/
public class ProductStep {

    public static  void 상품등록(){
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

    public static ExtractableResponse<Response>  조회등록(Long productId) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/products/{productId}",productId)
                .then().log().all().extract();

        return  response ;
    }
}
