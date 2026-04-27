package com.nexora.auth.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexora.auth.dto.LoginRequest;
import com.nexora.auth.dto.LogoutRequest;
import com.nexora.auth.dto.RegisterRequest;
import com.nexora.auth.dto.TokenResponse;
import com.nexora.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logOut(@RequestBody LogoutRequest logoutRequest) {
        authService.logOut(logoutRequest);
        return ResponseEntity.ok("Logged out successfully");
    }

}
