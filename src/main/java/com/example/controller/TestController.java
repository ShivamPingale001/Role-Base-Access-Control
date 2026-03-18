package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.config.JwtUtil;
import io.jsonwebtoken.Claims;
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicApi() {
        return "This is public API";
    }

    @GetMapping("/user")
    public String userApi(@RequestHeader("Authorization") String token) {

        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Claims claims = JwtUtil.extractClaims(token);
            String role = claims.get("role", String.class);

            if (role.equals("USER") || role.equals("ADMIN")) {
                return "User API Access Granted";
            }

            return "Access Denied";

        } catch (Exception e) {
            return "Invalid or Missing Token";
        }
    }

    @GetMapping("/admin")
    public String adminApi(@RequestHeader("Authorization") String token) {

        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Claims claims = JwtUtil.extractClaims(token);
            String role = claims.get("role", String.class);

            if (role.equals("ADMIN")) {
                return "Admin API Access Granted";
            }

            return "Access Denied";

        } catch (Exception e) {
            return "Invalid or Missing Token";
        }
    }
}	