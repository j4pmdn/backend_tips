package com.hdoan.repository;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    ProductEntity createProduct(ProductEntity product);
    List<ProductEntity> findAllProducts();

}
