package com.we_hack.smart_order_managment_system.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequestDto(

        String IIN,

        @NotBlank(message = "Password cannot be blank")
        String password

) { }
