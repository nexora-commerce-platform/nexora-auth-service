package com.nexora.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RefreshToken {
    @JsonProperty("refresh_token")
    private String refreshToken;
}
