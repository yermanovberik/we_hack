package com.we_hack.smart_order_managment_system.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class ApiAuthenticationException extends AuthenticationException {

    private final HttpStatus httpStatus;

    public ApiAuthenticationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
