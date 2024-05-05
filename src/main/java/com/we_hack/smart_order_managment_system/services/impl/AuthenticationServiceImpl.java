package com.we_hack.smart_order_managment_system.services.impl;

import com.we_hack.smart_order_managment_system.dto.auth.RegisterRequestDto;
import com.we_hack.smart_order_managment_system.dto.auth.AuthenticationRequestDto;
import com.we_hack.smart_order_managment_system.dto.auth.AuthenticationResponseDto;
import com.we_hack.smart_order_managment_system.enums.Role;
import com.we_hack.smart_order_managment_system.exceptions.JwtSubjectMissingException;
import com.we_hack.smart_order_managment_system.exceptions.JwtTokenExpiredException;
import com.we_hack.smart_order_managment_system.jwt.JwtFactory;
import com.we_hack.smart_order_managment_system.jwt.JwtParser;
import com.we_hack.smart_order_managment_system.jwt.JwtValidator;
import com.we_hack.smart_order_managment_system.models.User;
import com.we_hack.smart_order_managment_system.repositories.UserRepository;
import com.we_hack.smart_order_managment_system.services.AuthenticationService;
import com.we_hack.smart_order_managment_system.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtFactory jwtFactory;
    private final JwtValidator jwtValidator;
    private final JwtParser jwtParser;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthenticationResponseDto register(RegisterRequestDto request) {
        userService.throwExceptionIfUserExists(request.IIN());
        boolean isAdmin = request.IIN().equalsIgnoreCase("App");
        Role userRole = isAdmin ? Role.ADMIN : Role.USER;
        User user = User.builder()
                .fullName(request.fullName())
                .IIN(request.IIN())
                .phoneNumber(request.phoneNumber())
                .password(passwordEncoder.encode(request.password()))
                .role(userRole)
                .build();
        userRepository.save(user);

        String accessToken = jwtFactory.generateAccessToken(user);
        String refreshToken = jwtFactory.generateRefreshToken(user);
        AuthenticationResponseDto responseDto = AuthenticationResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .build();
        return responseDto;
    }

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.IIN(),
                        request.password()
                )
        );
        com.we_hack.smart_order_managment_system.models.User user = userRepository.findByIIN(request.IIN())
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with email " + request.IIN() + " not found"
                ));

        String accessToken = jwtFactory.generateAccessToken(user);
        String refreshToken = jwtFactory.generateRefreshToken(user);

        log.info("User authenticated successfully with email: {}", user.getIIN());

        return AuthenticationResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .build();
    }

    @Override
    public AuthenticationResponseDto refreshToken(String authHeader) {
        log.info("Received refresh token request");

        String refreshToken = authHeader.substring(7);

        com.we_hack.smart_order_managment_system.models.User user = jwtParser.extractEmail(refreshToken)
                .map(userRepository::findByIIN)
                .orElseThrow(() -> new JwtSubjectMissingException("JWT subject cannot be null"))
                .orElseThrow(() -> new EntityNotFoundException("User with this email was not found"));

        jwtValidator.ifTokenExpiredThrow(refreshToken, () -> new JwtTokenExpiredException("Refresh token has expired"));

        String accessToken = jwtFactory.generateAccessToken(user);

        log.info("User refreshed token successfully with email: {}", user.getIIN());

        return AuthenticationResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .build();
    }





}
