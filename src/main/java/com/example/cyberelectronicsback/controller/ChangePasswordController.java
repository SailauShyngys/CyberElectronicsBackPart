package com.example.cyberelectronicsback.controller;

import com.example.cyberelectronicsback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/change-password")
public class ChangePasswordController {
    private final UserService userService;

    @PostMapping("/request")
    public ResponseEntity<String> requestChange(@RequestParam("email") String email, @RequestParam("mobileNumber") String mobileNumber) throws Exception {
        boolean userExists = userService.verifyUser(email, mobileNumber);

        if (userExists) {
            return ResponseEntity.ok("Пользователь найден. Перенаправление на страницу смены пароля.");
        } else {
            return ResponseEntity.badRequest().body("Пользователь с такой почтой и номером телефона не найден.");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestParam String npws) throws Exception {
        boolean passwordChanged = userService.updatePassword(id, npws);

        if (passwordChanged) {
            return ResponseEntity.ok("Пароль успешно изменен.");
        } else {
            return ResponseEntity.badRequest().body("Не удалось изменить пароль.");
        }
    }

}
