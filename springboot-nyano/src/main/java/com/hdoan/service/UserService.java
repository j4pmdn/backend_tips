package com.hdoan.service;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity creaUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // get all by limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    // get search by limit offset
    Page<UserEntity> findByUserName(String name, Pageable pageable);
}
