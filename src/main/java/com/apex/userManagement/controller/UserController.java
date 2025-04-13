package com.apex.userManagement.controller;

import com.apex.userManagement.dto.UserRequest;
import com.apex.userManagement.dto.UserResponse;
import com.apex.userManagement.exception.UserAlreadyExistException;
import com.apex.userManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // api for user signup
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> userSignUp(@RequestBody UserRequest userRequest) throws UserAlreadyExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequest));
    }

}
