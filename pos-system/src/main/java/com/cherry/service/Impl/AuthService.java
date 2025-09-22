package com.cherry.service.Impl;

import com.cherry.payload.dto.UserDto;
import com.cherry.payload.response.AuthResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    AuthResponse signup(UserDto userDto);
    AuthResponse login(UserDto userDto);
}
