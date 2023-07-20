package com.ex.ord.adapter;

import com.ex.ord.entity.Product;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.repository.ProductRepository;

/**
 * fileName:ProductAdapter
 * 작성날짜:2023-07-20
 * desc :
 **/
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
