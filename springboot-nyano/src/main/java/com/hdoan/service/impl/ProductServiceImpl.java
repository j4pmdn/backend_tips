package com.hdoan.service.impl;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.ProductEntity;
import com.hdoan.repository.ProductRepository;
import com.hdoan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
