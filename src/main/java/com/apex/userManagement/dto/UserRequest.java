package com.apex.userManagement.dto;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
}
