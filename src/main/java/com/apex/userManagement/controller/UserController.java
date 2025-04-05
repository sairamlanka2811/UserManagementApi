package com.apex.userManagement.controller;

import com.apex.userManagement.entity.User;
import com.apex.userManagement.exception.UserAlreadyExistException;
import com.apex.userManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> userSignUp(@RequestBody User user) throws UserAlreadyExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

}
