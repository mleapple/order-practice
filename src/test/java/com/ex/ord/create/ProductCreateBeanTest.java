package com.ex.ord.create;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.RequestProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * fileName:ProductCrateTest
 * 작성날짜:2023-07-20
 * desc :
 **/

@SpringBootTest
class ProductCreateBeanTest {


    @Autowired
    private ProductService productService; // 상품 등록 서버스

    @BeforeEach
    void setUp() {
        // 아직 빈이 없으니까
    }
    @Test
    void 상품생성하기_BEAN(){
        // 상품 요청 테스트 러프하게
        RequestProduct request = new RequestProduct("노트북",1000, DiscountPolicy.DC10); // 저장 DTL
        productService.creatProduct(request); // 메모리 저장하기
    }

}