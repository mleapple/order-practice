package com.ex.ord.service;

import com.ex.ord.entity.Product;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.service.dto.RequestProduct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * fileName:ProductService
 * 작성날짜:2023-07-20
 * desc :
 **/
@Service
public class ProductService {

    private final ProductPort productPort;

    // db로 저장 하기
    public ProductService(@Qualifier("productBeanAdapter") ProductPort productPort) {
        this.productPort = productPort;
    }

    public void creatProduct(RequestProduct request) {
        final Product product = new Product(request.getName(), request.getPrice(), request.getDiscountPoliy());
        productPort.save(product);
    }
}
