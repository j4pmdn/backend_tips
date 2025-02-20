package com.hdoan;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.CCCDEntity;
import com.hdoan.entity.user.UserEntity;
import com.hdoan.repository.CCCDRepository;
import com.hdoan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class UserCCCDTest{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest(){
        UserEntity user = new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("Tips CCCD");
        user.setUserEmail("cccd01@gmail.com");

        cccd.setNumberCCCD("111222333");
        user.setCccd(cccd);

        userRepository.save(user);
    }
}
