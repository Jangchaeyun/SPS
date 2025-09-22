package com.cherry.payload.response;

import com.cherry.payload.dto.UserDto;

public class AuthResponse {
    private String jwt;
    private String message;
    private UserDto user;
}
