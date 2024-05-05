package com.we_hack.smart_order_managment_system.dto.user;


import lombok.Builder;

@Builder
public record UserRequestDto (

        String fullNamE,

        String IIN,

        String password,
        String phoneNumber


) { }
