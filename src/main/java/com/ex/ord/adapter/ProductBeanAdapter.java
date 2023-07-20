package com.ex.ord.adapter;

import com.ex.ord.entity.DiscountPolicy;
import com.ex.ord.entity.Product;
import com.ex.ord.repository.ProductDbRepository;
import com.ex.ord.repository.ProductPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * fileName:ProductAdapter
 * 작성날짜:2023-07-20
 * desc :
 **/
@Component
@Qualifier("productBeanAdapter")
public class ProductBeanAdapter implements ProductPort {
    private final ProductDbRepository productDbRepository;// , db로 저장

    public ProductBeanAdapter(ProductDbRepository productDbRepository) {
        this.productDbRepository = productDbRepository;
    }

    @Override
    public void save(final Product product) {// dto 저장 하기
        productDbRepository.save(product);
    }

    @Override
    public Product getProudct(Long productId) {//
        return    productDbRepository.findById(productId).orElseThrow(()->new IllegalArgumentException());

    }
}
