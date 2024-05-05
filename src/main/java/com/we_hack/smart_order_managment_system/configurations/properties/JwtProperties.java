package com.we_hack.smart_order_managment_system.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.security.jwt")
public record JwtProperties(
        String secretKey,
        long accessTokenExpiration,

        long refreshTokenExpiration
) {

}
