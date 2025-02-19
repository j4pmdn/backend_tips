package com.hdoan.service;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity creaUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
}
