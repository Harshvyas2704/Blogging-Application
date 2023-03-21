package com.bloggingappapis.services;

import com.bloggingappapis.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getALlUsers();
    void deleteUser(Integer userId);

}
