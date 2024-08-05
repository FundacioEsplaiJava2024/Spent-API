package com.grupo.spent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo.spent.entities.User;
import com.grupo.spent.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User register(String email, String username, String name, String password) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        User user = User.builder()
                .email(email)
                .username(username)
                .firstName(name)
                .password(encryptedPassword)
                .build();
        return userRepository.save(user);
    }

    public String login(String email, String password) {
        String token = "";
        return token;
    }
}
