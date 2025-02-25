package com.hdoan.controller;/*
 * @project spring-security
 * @author Huy
 */

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@RolesAllowed("ADMIN")
// @PostAuthorize("hasIpAddress("111.222")")
public class AdminController {

    // @RolesAllowed("ADMIN")
    @GetMapping("/vip")
    public String zoneVip() {
        return "zoneVip";
    }

    // @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/normal")
    public String zoneNormal() {
        return "zoneNormal";
    }

    @GetMapping("/info")
    public Authentication getInfoUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
