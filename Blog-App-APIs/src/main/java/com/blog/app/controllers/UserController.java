package com.blog.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.payloads.ApiResponse;
import com.blog.app.payloads.UserDto;
import com.blog.app.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
		
		UserDto createUserDto = this.userService.createUser(userdto);
		return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
		
	}
	
	
	// PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userdto, @PathVariable("userId") Integer userId){
		
		UserDto  updatedUser = this.userService.updateUser(userdto, userId);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}
	
	
	// DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser (@PathVariable Integer userId) {
		
		this.userService.deleteUser(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
		
	}
	
	
	// GET - get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		
		return ResponseEntity.ok(this.userService.getAllUsers());
		
		
	}
	
	
	
	// GET - get all users
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		
		return new ResponseEntity<UserDto>(this.userService.getUserById(userId), HttpStatus.OK);
		
	}
	
}
