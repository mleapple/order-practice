package com.ex.ord.repository;

import com.ex.ord.entity.Product;

/**
 * fileName:productPort
 * 작성날짜:2023-07-20
 * desc :
 **/
public interface ProductPort {
    void save(final Product product);

    Product getProudct(Long productId);
}
