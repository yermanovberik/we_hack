package com.we_hack.smart_order_managment_system.configurations.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.we_hack.smart_order_managment_system.dto.ApiExceptionResponseDto;
import com.we_hack.smart_order_managment_system.exceptions.ApiAuthenticationException;
import com.we_hack.smart_order_managment_system.exceptions.ApiExceptionResponseFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;
    private final ApiExceptionResponseFactory apiExceptionResponseFactory;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;

        if (authException instanceof ApiAuthenticationException apiAuthenticationException) {
            httpStatus = apiAuthenticationException.getHttpStatus();
        }

        response.setStatus(httpStatus.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ApiExceptionResponseDto errorResponse = apiExceptionResponseFactory.createApiExceptionResponseDto(
                httpStatus,
                authException.getMessage()
        );

        String jsonResponse = objectMapper.writeValueAsString(errorResponse);

        try (PrintWriter writer = response.getWriter()) {
            writer.write(jsonResponse);
            writer.flush();
        }
    }

}
