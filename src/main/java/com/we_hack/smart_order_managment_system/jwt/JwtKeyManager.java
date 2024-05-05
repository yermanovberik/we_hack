package com.we_hack.smart_order_managment_system.jwt;

import com.we_hack.smart_order_managment_system.configurations.properties.JwtProperties;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@RequiredArgsConstructor
public class JwtKeyManager {

    private final JwtProperties jwtProperties;

    public Key getSignInKey() {
        String secretKey = jwtProperties.secretKey();
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
