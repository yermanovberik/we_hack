package com.we_hack.smart_order_managment_system.services.impl;

import com.we_hack.smart_order_managment_system.dto.user.UserRequestDto;
import com.we_hack.smart_order_managment_system.dto.user.UserResponseDto;
import com.we_hack.smart_order_managment_system.exceptions.entity.EntityAlreadyExistsException;
import com.we_hack.smart_order_managment_system.models.User;
import com.we_hack.smart_order_managment_system.repositories.UserRepository;
import com.we_hack.smart_order_managment_system.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void throwExceptionIfUserExists(String email) {
        userRepository.findByIIN(email)
                .ifPresent(foundUser -> {
                    throw new EntityAlreadyExistsException(
                            "User with the iin " + foundUser.getIIN() + " already exists"
                    );
                });
    }


    @Override
    public UserResponseDto getById(long id) {
        return null;
    }

    @Override
    public UserResponseDto create(UserRequestDto requestDto) {
        return null;
    }

    @Override
    public UserResponseDto update(long id, UserRequestDto requestDto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User getEntityById(long id) {
        return null;
    }
}
