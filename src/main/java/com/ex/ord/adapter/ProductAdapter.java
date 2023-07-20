package com.ex.ord.adapter;

import com.ex.ord.entity.Product;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * fileName:ProductAdapter
 * 작성날짜:2023-07-20
 * desc :
 **/
@Component
@Qualifier("productAdapter")
public class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;// 메모리로 ? , db

    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {// dto 저장 하기
        productRepository.save(product);
    }
}
