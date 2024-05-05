package com.we_hack.smart_order_managment_system.exceptions;

import org.springframework.http.HttpStatus;

public class JwtTokenExpiredException extends ApiAuthenticationException {

    public JwtTokenExpiredException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }

}
