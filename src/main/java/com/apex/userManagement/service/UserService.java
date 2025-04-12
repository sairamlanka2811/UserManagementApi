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

    public UserResponse addUser(UserRequest userRequest) throws UserAlreadyExistException {
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("User with mobile number " + userRequest.getUsername() + " already exist");
        }

        User user = modelMapper.map(userRequest, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }
}