package com.hdoan.repository;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
