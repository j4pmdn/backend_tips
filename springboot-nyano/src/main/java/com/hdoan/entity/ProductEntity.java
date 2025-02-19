package com.hdoan.entity;/*
 * @project springboot-nyano
 * @author Huy
 */

import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table(name = "java_product_001")
public class ProductEntity {

    private Long id;
    private String productName;
    private BigDecimal productPrice;

    // get

    // set

}
