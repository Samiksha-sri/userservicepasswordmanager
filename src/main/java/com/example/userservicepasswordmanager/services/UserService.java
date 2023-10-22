package com.example.userservicepasswordmanager.services;

import com.example.userservicepasswordmanager.dtos.UserDto;
import com.example.userservicepasswordmanager.exceptions.UserRegistrationException;

public interface UserService {

    UserDto registerUser(UserDto userDto) throws UserRegistrationException;
}
