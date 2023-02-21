package com.blog.app.services;

import com.blog.app.payloads.UserDto;
import java.util.List;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	String deleteUser(Integer userId);

}
