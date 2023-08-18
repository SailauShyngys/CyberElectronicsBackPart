package com.example.cyberelectronicsback.service;

import com.example.cyberelectronicsback.controller.dto.UserCreateDto;
import com.example.cyberelectronicsback.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User updateUser(Long id, UserCreateDto createDto)throws Exception;
    List<User> getByAllUser()throws Exception;
    void deleteUser(Long id)throws Exception;
    boolean verifyUser(String email, String phoneNumber)throws Exception;
    boolean updatePassword(Long id, String npws)throws Exception;
    User registration(UserCreateDto dto);
    Optional<User> findByUsername(String username);
    String login(UserCreateDto dto);
}