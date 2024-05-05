package com.we_hack.smart_order_managment_system.controllers;

import com.we_hack.smart_order_managment_system.dto.auth.AuthenticationRequestDto;
import com.we_hack.smart_order_managment_system.dto.auth.AuthenticationResponseDto;
import com.we_hack.smart_order_managment_system.dto.auth.RegisterRequestDto;
import com.we_hack.smart_order_managment_system.services.AuthenticationService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticationResponseDto register(
            @RequestBody RegisterRequestDto request
    ) {
        return authenticationService.register(request);
    }


    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponseDto authenticate(
            @RequestBody AuthenticationRequestDto request)
    {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/refresh-token")
    public AuthenticationResponseDto refreshToken(
            @RequestHeader(HttpHeaders.AUTHORIZATION)
            @Pattern(regexp = "Bearer .*", message = "Authorization header must start with 'Bearer '")
            String authHeader
    ) {
        return authenticationService.refreshToken(authHeader);
    }




}
