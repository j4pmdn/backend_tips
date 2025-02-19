package com.hdoan.service;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductEntity product);
    List<ProductEntity> findAllProducts();
}
