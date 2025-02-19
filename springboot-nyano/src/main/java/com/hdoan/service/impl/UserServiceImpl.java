package com.hdoan.service.impl;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.UserEntity;
import com.hdoan.repository.UserRepository;
import com.hdoan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity creaUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
