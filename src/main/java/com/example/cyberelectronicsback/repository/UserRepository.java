package com.example.cyberelectronicsback.repository;
import com.example.cyberelectronicsback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameIgnoreCase(String username);
    User findByEmailAndPhoneNumber(String email, String phoneNumber);
    List<User> findAll();
}