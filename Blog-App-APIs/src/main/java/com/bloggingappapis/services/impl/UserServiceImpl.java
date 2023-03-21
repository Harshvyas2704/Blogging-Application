package com.bloggingappapis.services.impl;

import com.bloggingappapis.entities.User;
import com.bloggingappapis.exceptions.ResourceNotFoundException;
import com.bloggingappapis.payloads.UserDto;
import com.bloggingappapis.repositories.UserRepo;
import com.bloggingappapis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);

        return this.userToDto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "User Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);

        return this.userToDto(updatedUser);

    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        return userToDto(user);

    }

    @Override
    public List<UserDto> getALlUsers() {

        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos =  users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

        return userDtos;

    }

    @Override
    public void deleteUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "User Id", userId));

        this.userRepo.delete(user);


    }

    public User dtoToUser(UserDto userDto){

        User user = this.modelMapper.map(userDto, User.class);

//        user.setUserId(userDto.getUserId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());

        return user;

    }

    public UserDto userToDto(User user){

        UserDto userDto = this.modelMapper.map(user, UserDto.class);

        return userDto;

    }
}
