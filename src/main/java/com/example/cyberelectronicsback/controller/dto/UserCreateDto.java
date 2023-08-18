package com.example.cyberelectronicsback.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String shippingAddress;
    private String phoneNumber;
}
