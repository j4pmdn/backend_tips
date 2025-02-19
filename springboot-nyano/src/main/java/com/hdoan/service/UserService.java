package com.hdoan.service;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity creaUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
