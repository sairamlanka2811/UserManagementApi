package com.apex.userManagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private Long username;
    private String firstName;
    private String lastName;
    private String address;
}
