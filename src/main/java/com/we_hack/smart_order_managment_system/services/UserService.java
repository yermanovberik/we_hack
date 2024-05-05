package com.we_hack.smart_order_managment_system.services;

import com.we_hack.smart_order_managment_system.dto.user.UserRequestDto;
import com.we_hack.smart_order_managment_system.dto.user.UserResponseDto;
import com.we_hack.smart_order_managment_system.models.User;

public interface UserService extends CrudService<User, UserRequestDto, UserResponseDto> {

    void throwExceptionIfUserExists(String email);


}
