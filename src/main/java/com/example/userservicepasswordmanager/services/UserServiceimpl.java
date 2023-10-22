package com.example.userservicepasswordmanager.services;

import com.example.userservicepasswordmanager.dtos.UserDto;
import com.example.userservicepasswordmanager.exceptions.UserRegistrationException;
import com.example.userservicepasswordmanager.models.User;
import com.example.userservicepasswordmanager.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    private UserRepository userRepository;


    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto registerUser(UserDto userDto) throws UserRegistrationException {
       User user = userRepository.findByEmailIgnoreCase(userDto.getEmail());
        if(user != null){
            throw new UserRegistrationException("User already exists. Please login");
        }

        User registerUser = new User();
        registerUser.setEmail(userDto.getEmail());
        String password = userDto.getPassword();
        String encryptedPassword = encryptPassword(password);
        registerUser.setPassword(encryptedPassword);
        userRepository.save(registerUser);
        userDto.setPassword(encryptedPassword);
        userDto.setId(registerUser.getId());
        return userDto;
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);
        String encryptedPassword = passwordEncoder.encode(password);
        return encryptedPassword;
    }
}
