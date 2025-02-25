package com.hdoan.config;/*
 * @project spring-security
 * @author Huy
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //active spring web security
@EnableMethodSecurity(jsr250Enabled = true) // active annotation @RolesAllowed
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // tack backend vs frontend
        http.formLogin((formLogin) -> formLogin.loginProcessingUrl("/login"));

        http.authorizeHttpRequests(req -> req
                .requestMatchers("/api/v1/auth/login", "/api/v1/auth/register")
                .permitAll()
//                .requestMatchers("/v1/api/admin/normal").hasAnyRole("ADMIN", "USER")
//                .requestMatchers("/v1/api/admin/vip").hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        return http.build();
    }

    /**
     * Config user Information
     * @return
     */

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123") // raw
//                .roles("admin", "user")
//                .build();
//
//        UserDetails user = User
//                .withUsername("user")
//                .password("{noop}222") // raw
//                .roles("user")
//                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("123")) // raw
                // .roles("admin", "user") // ROLE_admin
                .authorities("ROLE_ADMIN", "ROLE_USER")
                //.authorities("ROLE_admin", "ROLE_user", "order:read", "order:write")
                // Roles vs Authorities
                // Nên sử dụng Authorities
                .build();

        UserDetails user = User
                .withUsername("user")
                .password(passwordEncoder().encode("123")) // raw
                .authorities("ROLE_USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
}
