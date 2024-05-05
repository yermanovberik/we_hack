package com.we_hack.smart_order_managment_system.dto.auth;

import lombok.Builder;

@Builder
public record AuthenticationResponseDto(
        String accessToken,
        String refreshToken,
        Long userId
) { }
