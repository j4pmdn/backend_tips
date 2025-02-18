package com.shopdevjava.springboot_hello.controller;/*
 * @project springboot-hello
 * @author Huy
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Value("${player.username}")
    private String playerName;

    @Value("${player.age}")
    private int playerAge;

    @Value("${player.address}")
    private String playerAddress;

    @GetMapping("/v1/api/player/1")
    public String getInfoPlayer(){
        return playerName + " " + playerAge + " " + playerAddress;
    }

}
