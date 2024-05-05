package com.we_hack.smart_order_managment_system.dto.auth;


import lombok.Builder;
@Builder
public record RegisterRequestDto(


        String fullName,

        String IIN,

        String password,
        String phoneNumber


) { }
