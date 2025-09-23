package com.cherry.payload.response;

import com.cherry.payload.dto.UserDto;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private UserDto user;
}
