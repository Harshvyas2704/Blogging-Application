package com.bloggingappapis.controllers;

import com.bloggingappapis.payloads.ApiResponse;
import com.bloggingappapis.payloads.UserDto;
import com.bloggingappapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // POST - create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

        UserDto createdUser = this.userService.createUser(userDto);

        return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);

    }

    // PUT - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){

        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);

    }

    // DELETE - delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){

        this.userService.deleteUser(userId);

        return new ResponseEntity(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

    // GET - get user
    @GetMapping("/{userId}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){

        return ResponseEntity.ok(this.userService.getUserById(userId));


    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getALlUsers(){

        return ResponseEntity.ok(this.userService.getALlUsers());
    }

}

