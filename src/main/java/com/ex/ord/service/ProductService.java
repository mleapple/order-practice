package com.ex.ord.service;

import com.ex.ord.entity.Product;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.service.dto.RequestProduct;

/**
 * fileName:ProductService
 * 작성날짜:2023-07-20
 * desc :
 **/
public class ProductService {

    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    public void creatProduct(RequestProduct request) {
        final Product product = new Product(request.getName(), request.getPrice(), request.getDiscountPoliy());
        productPort.save(product);
    }
}
