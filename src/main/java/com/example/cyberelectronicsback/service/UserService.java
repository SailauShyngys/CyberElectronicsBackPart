package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.controller.dto.UserCreateDto;
import com.example.cyberelectronicsback.model.User;

import java.util.Optional;

public interface UserService {
    //    User createUser(UserCreateDto createDto)throws Exception;
//    void updateUser(Long id, UserCreateDto createDto)throws Exception;
//    List<User> getByAllUser()throws Exception;
//    void deleteUser(Long id)throws Exception;
    User registration(UserCreateDto dto);
    Optional<User> findByUsername(String username);
    String login(UserCreateDto dto);
}