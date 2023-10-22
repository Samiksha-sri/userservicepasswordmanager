package com.example.userservicepasswordmanager.controllers;

import com.example.userservicepasswordmanager.dtos.UserDto;
import com.example.userservicepasswordmanager.exceptions.UserRegistrationException;
import com.example.userservicepasswordmanager.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userDto) throws UserRegistrationException {

        return userService.registerUser(userDto);
    }
}
