package com.apex.userManagement.service;

import com.apex.userManagement.dto.UserRequest;
import com.apex.userManagement.dto.UserResponse;
import com.apex.userManagement.entity.User;
import com.apex.userManagement.exception.UserAlreadyExistException;
import com.apex.userManagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    // adding a user
    public UserResponse addUser(UserRequest userRequest) throws UserAlreadyExistException {

        // username and password are mandatory fields
        if (userRequest.getUsername() == null || userRequest.getUsername().isEmpty() || userRequest.getPassword() == null || userRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Mandatory fields are missing");
        }

        // throwing exception when duplicate username is present
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("User with mobile number " + userRequest.getUsername() + " already exist");
        }

        // mapping user request to User class
        User user = modelMapper.map(userRequest, User.class);

        // saving user to database using repository
        userRepository.save(user);

        // mapping user to UserResponse class and returning UserResponse object
        return modelMapper.map(user, UserResponse.class);
    }
}