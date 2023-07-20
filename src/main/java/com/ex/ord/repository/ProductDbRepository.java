package com.ex.ord.repository;

import com.ex.ord.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * fileName:ProductDbRepository
 * 작성날짜:2023-07-20
 * desc :
 **/
public interface ProductDbRepository extends CrudRepository<Product,Long> {
}
