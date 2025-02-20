package com.hdoan.repository;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.CCCDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CCCDRepository extends JpaRepository<CCCDEntity, Long> {
}
