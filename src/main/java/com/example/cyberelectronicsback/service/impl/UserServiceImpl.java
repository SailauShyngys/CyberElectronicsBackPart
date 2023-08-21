package com.example.cyberelectronicsback.service.impl;

import com.example.cyberelectronicsback.config.JwtUtils;
import com.example.cyberelectronicsback.controller.dto.UserCreateDto;
import com.example.cyberelectronicsback.model.User;
import com.example.cyberelectronicsback.repository.UserRepository;
import com.example.cyberelectronicsback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;


    @Override
    public User updateUser(Long id, UserCreateDto createDto) throws Exception {
        User user = userRepository.findById(id).orElseThrow();
        if (id != null){
            user.setUsername(createDto.getUsername());
            user.setFirstName(createDto.getFirstName());
            user.setLastName(createDto.getLastName());
            user.setEmail(createDto.getEmail());
            user.setShippingAddress(createDto.getShippingAddress());
            user.setPhoneNumber(createDto.getPhoneNumber());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getByAllUser() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public boolean verifyUser(String email, String phoneNumber) throws Exception {
        User user = userRepository.findByEmailAndPhoneNumber(email, phoneNumber);
        return user!=null;
    }

    @Override
    public boolean updatePassword(Long id, String npsw) throws Exception {
        User user = userRepository.findById(id).orElseThrow();

        if(user != null){
            String hashedPassword = passwordEncoder.encode(npsw);
            user.setPassword(hashedPassword);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User registration(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setShippingAddress(dto.getShippingAddress());
        user.setPhoneNumber(dto.getPhoneNumber());

        return userRepository.save(user);
    }

    @Override
    public String login(UserCreateDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());

        if(userDetails != null) {
            String token = jwtUtils.generateToken(userDetails);
            return token;
        }

        return "not auth";
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }
}