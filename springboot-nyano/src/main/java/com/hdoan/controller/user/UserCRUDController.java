package com.hdoan.controller.user;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.UserEntity;
import com.hdoan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.creaUser(userEntity);
    }

    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String name, @RequestParam String email){
        return userService.findByUserNameAndUserEmail(name, email);
    }

}
