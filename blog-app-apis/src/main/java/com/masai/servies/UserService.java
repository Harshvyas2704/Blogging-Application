package com.masai.servies;

import java.util.List;

import com.masai.payloads.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userdto);
	
	public UserDto updateUser(UserDto userdto, Integer userId);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAllUsers();
	
	public void deleteUser(Integer userId);

}
