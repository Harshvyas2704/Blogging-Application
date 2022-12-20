package com.masai.controllers;

import java.util.List;

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

import com.masai.payloads.ApiResponse;
import com.masai.payloads.UserDto;
import com.masai.servies.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto){
		
		UserDto createdUserDto = this.userService.createUser(userdto);
		
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
		
	}
	
	// PUT - update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable("userId") Integer userId){
		
		UserDto updatedUser = this.userService.updateUser(userdto, userId);
		
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		
	}
	
	// DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
		
		this.userService.deleteUser(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully...", true), HttpStatus.OK);
		
	}
	
	// GET - user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
	
		
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUsersById(@PathVariable("userId") Integer userId){
	
		
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	

}
