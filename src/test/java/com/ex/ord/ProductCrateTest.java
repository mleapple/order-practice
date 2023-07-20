package com.ex.ord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        RequestProduct request = new RequestProduct("노트북",1000,DiscountPoliy.DC10); // 저장 DTL
        productService.creatProduct(request); // 서장하기
    }

     class Product {
        private Long id;
        private final String name;
        private final long price;
        private final DiscountPoliy discountPoliy;


         public Long getId() {
             return id;
         }

         public String getName() {
            return name;
        }

        public long getPrice() {
            return price;
        }
        public DiscountPoliy getDiscountPoliy() {
            return discountPoliy;
        }
        public Product(String name, long price, DiscountPoliy discountPoliy) {
            this.name = name;
            this.price = price;
            this.discountPoliy = discountPoliy;
        }

         public void assignId(final Long id) {
            this.id = id;
         }
     }

     class ProductService {

        private final  ProductPort productPort;

        public ProductService(ProductPort productPort) {
            this.productPort = productPort;
        }

        public void creatProduct(RequestProduct request) {
            final Product product = new Product(request.getName() , request.getPrice() , request.getDiscountPoliy());
            productPort.save(product);
        }
    }
    class ProductAdapter implements ProductPort {
        private final ProductRepository productRepository ;// 메모리로 ? , db

        public ProductAdapter(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(final Product product) {// dto 저장 하기
            productRepository.save( product);
        }
    }
}