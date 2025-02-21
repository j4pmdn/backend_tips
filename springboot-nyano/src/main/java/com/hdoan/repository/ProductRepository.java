package com.hdoan.repository;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
