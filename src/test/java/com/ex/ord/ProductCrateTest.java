package com.ex.ord;

import com.ex.ord.adapter.ProductAdapter;

import com.ex.ord.entity.DiscountPoliy;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.repository.ProductRepository;

import com.ex.ord.service.ProductService;
import com.ex.ord.service.dto.RequestProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * fileName:ProductCrateTest
 * 작성날짜:2023-07-20
 * desc :
 **/

class ProductCrateTest {

    private ProductService productService; // 상품 등록 서버스
    private ProductPort productPort; // 저장 포트
    private ProductRepository productRepository; // 저장 리파지토리

    @BeforeEach
    void setUp() {
        // 아직 빈이 없으니까
        productRepository = new ProductRepository();
        productPort       = new ProductAdapter(productRepository);
        productService    = new ProductService(productPort);
    }
    @Test
    void enumTest(){
        for(DiscountPoliy d : DiscountPoliy.values()){
            System.out.println(" = " + d+"="+d.getDiscount());
        }
    }
    @Test
    void 상품생성하기(){
        // 상품 요청 테스트 러프하게
        RequestProduct request = new RequestProduct("노트북",1000, DiscountPoliy.DC10); // 저장 DTL
        productService.creatProduct(request); // 저장하기
    }
}