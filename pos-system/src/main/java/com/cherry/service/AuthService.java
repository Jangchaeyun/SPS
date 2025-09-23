package com.cherry.service;

import com.cherry.exceptions.UserException;
import com.cherry.payload.dto.UserDto;
import com.cherry.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}
