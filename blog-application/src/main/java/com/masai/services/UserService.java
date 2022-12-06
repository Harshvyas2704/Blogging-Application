package com.masai.services;

import java.util.List;
import com.masai.paylods.UserDto;


public interface UserService {
	
	public UserDto createUser(UserDto user);
	
	public UserDto updateUser(UserDto user, Integer userId);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAllUser();
	
	public void deleteUser(Integer userId);

}
