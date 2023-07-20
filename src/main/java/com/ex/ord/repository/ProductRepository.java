package com.ex.ord.repository;

import com.ex.ord.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName:ProductRepository
 * 작성날짜:2023-07-20
 * desc :
 **/
public class ProductRepository {
    // 메로리에 저장하기
    private Map<Long , Product> persistence= new HashMap<>();
    private Long seq =0L;
    public void save(Product product) {
        product.assignId(++seq); // 아이디 증가
        persistence.put(product.getId(),product);
    }
}
