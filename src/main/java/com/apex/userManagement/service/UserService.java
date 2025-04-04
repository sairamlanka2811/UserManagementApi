package com.apex.userManagement.service;

import com.apex.userManagement.entity.User;
import com.apex.userManagement.exception.UserAlreadyExistException;
import com.apex.userManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(User user) throws UserAlreadyExistException {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new UserAlreadyExistException("User with mobile number "+ user.getUsername() + " already exist");
        }
            userRepository.save(user);
            return "User with mobile number "+ user.getUsername()+ " registered successfully";


    }
}
