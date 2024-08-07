package com.grupo.spent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.spent.dtos.LoginDto;
import com.grupo.spent.dtos.RegisterDto;
import com.grupo.spent.dtos.RegisterResponseDto;
import com.grupo.spent.entities.User;
import com.grupo.spent.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        try {
            User user = userService.register(registerDto.getEmail(), registerDto.getUsername(), registerDto.getName(),
            registerDto.getPassword());
            // String token = userService.login(user.getEmail(), user.getPassword());
            String token = "manuel0";
            RegisterResponseDto registerResponseDto = new RegisterResponseDto(user.getEmail(), user.getUsername(), user.getFirstName(), token);

            return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            var accessToken = userService.login(loginDto.getEmail(), loginDto.getPassword());
            String formattedResponse = "accessToken: " + accessToken;
            return ResponseEntity.status(HttpStatus.OK).body(formattedResponse);
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

}
