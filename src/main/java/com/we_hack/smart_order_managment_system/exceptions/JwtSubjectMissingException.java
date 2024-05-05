package com.we_hack.smart_order_managment_system.exceptions;


import org.springframework.http.HttpStatus;

public class JwtSubjectMissingException extends ApiAuthenticationException {

    public JwtSubjectMissingException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

}
