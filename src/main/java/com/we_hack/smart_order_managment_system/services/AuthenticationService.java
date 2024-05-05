package com.we_hack.smart_order_managment_system.services;


import com.we_hack.smart_order_managment_system.dto.auth.RegisterRequestDto;
import com.we_hack.smart_order_managment_system.dto.auth.AuthenticationRequestDto;
import com.we_hack.smart_order_managment_system.dto.auth.AuthenticationResponseDto;

public interface AuthenticationService {

    AuthenticationResponseDto register(RegisterRequestDto request);
    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);
    AuthenticationResponseDto refreshToken(String authHeader);


}
