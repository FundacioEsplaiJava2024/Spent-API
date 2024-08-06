package com.grupo.spent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.spent.dtos.LoginDto;
import com.grupo.spent.dtos.RegisterDto;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(registerDto.getEmail(), registerDto.getUsername(), registerDto.getName(), registerDto.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        String token = userService.login(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

}
