package com.we_hack.smart_order_managment_system.exceptions.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityAlreadyExistsException extends ResponseStatusException {

    public EntityAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }

}
