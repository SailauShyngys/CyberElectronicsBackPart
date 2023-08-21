package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.controller.dto.UserCreateDto;
import com.example.cyberelectronicsback.model.User;
import com.example.cyberelectronicsback.repository.UserRepository;
import com.example.cyberelectronicsback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @Validated UserCreateDto dto) {
        if (userService.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        userService.registration(dto);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @GetMapping("api/user/list")
    public List<User> getAllUsers() throws Exception {
        return userService.getByAllUser();
    }

    @PutMapping("api/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserCreateDto createCto) throws Exception {
        return userService.updateUser(id, createCto);
    }

    @DeleteMapping("api/user/delete/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
    }
}