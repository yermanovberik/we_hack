package com.we_hack.smart_order_managment_system.dto.user;

import com.we_hack.smart_order_managment_system.enums.Role;
import lombok.Builder;

@Builder
public record UserResponseDto(
        long id,
        String email,
        Role role
) { }
