package com.we_hack.smart_order_managment_system.utils;

public class JwtUtils {

    public static final String BEARER_PREFIX = "Bearer ";

    public static String extractJwtFromHeader(String authHeader) {
        return authHeader.substring(BEARER_PREFIX.length());
    }

}