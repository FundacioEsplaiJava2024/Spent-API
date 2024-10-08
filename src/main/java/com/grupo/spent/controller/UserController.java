package com.grupo.spent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.spent.dtos.requests.LoginDto;
import com.grupo.spent.dtos.requests.RegisterDto;
import com.grupo.spent.dtos.responses.LoginResponseDto;
import com.grupo.spent.dtos.responses.RegisterResponseDto;
import com.grupo.spent.entities.User;
import com.grupo.spent.exceptions.HttpException;
import com.grupo.spent.exceptions.NotFoundException;
import com.grupo.spent.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto registerDto) throws NotFoundException {
        try {
            if (userService.existsUserByEmail(registerDto.getEmail())) {
                throw new HttpException(HttpStatus.BAD_REQUEST, "This User already exists.");
            }
            User user = userService.register(registerDto.getEmail(), registerDto.getUsername(), registerDto.getName(),
                    registerDto.getPassword());
            String token = userService.login(registerDto.getEmail(), registerDto.getPassword());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RegisterResponseDto(user.getEmail(), user.getUsername(), user.getFirstName(), token));
        } catch (HttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) throws NotFoundException {
        try {
            var accessToken = userService.login(loginDto.getEmail(), loginDto.getPassword());
            User user = userService.findUserByEmail(loginDto.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDto(user.getUsername(), accessToken));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserById(@PathVariable String username) throws NotFoundException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.findUserByUsername(username));
        } catch (HttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }
}
