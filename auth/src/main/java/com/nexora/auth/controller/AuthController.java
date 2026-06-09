package com.nexora.auth.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexora.auth.dto.LoginRequest;
import com.nexora.auth.dto.LogoutRequest;
import com.nexora.auth.dto.RefreshToken;
import com.nexora.auth.dto.RegisterRequest;
import com.nexora.auth.dto.TokenResponse;
import com.nexora.auth.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Authentication", description = "Register, login, logout endpoints")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @Operation(summary = "Login and get token")
    @ApiResponse(responseCode = "200", description = "Returns access and refresh tokens")
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Operation(summary = "get Access token by sending refresh token")
    @ApiResponse(responseCode = "200", description = " regenerating access token and refresh tokens")
    public ResponseEntity<TokenResponse> refreshToken(
            @RequestBody RefreshToken reqRefreshToken) {
        return ResponseEntity.ok(authService.refreshToken(reqRefreshToken));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logOut(@RequestBody LogoutRequest logoutRequest) {
        authService.logOut(logoutRequest);
        return ResponseEntity.ok("Logged out successfully");
    }

}
