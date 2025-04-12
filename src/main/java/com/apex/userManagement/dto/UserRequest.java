package com.apex.userManagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private Long username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
}
