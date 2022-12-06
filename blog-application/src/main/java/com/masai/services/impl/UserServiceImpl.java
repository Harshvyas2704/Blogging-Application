package com.masai.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.entities.User;
import com.masai.paylods.UserDto;
import com.masai.repositories.UserRepo;
import com.masai.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		// conversion because we are getting userDto and we want to use
		// entity class so we convert dto to entity then return dto via entity
		User user = dtoToUser(userDto);
		
		User savedUser = userRepo.save(user);
		
		return userToDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	
	private User dtoToUser(UserDto userDto) {
		
		User user = new User();
		
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setUserEmail(userDto.getUserEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		
		UserDto userDto = new UserDto();
		
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		userDto.setUserEmail(user.getUserEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());
		
		return userDto;
		
	}

}
