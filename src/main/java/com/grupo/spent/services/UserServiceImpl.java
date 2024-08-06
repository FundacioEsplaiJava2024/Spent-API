package com.grupo.spent.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo.spent.auth.TokenProvider;
import com.grupo.spent.entities.User;
import com.grupo.spent.entities.UserRoleEnum;
import com.grupo.spent.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(String email, String username, String name, String password) {
        String encryptedPassword = passwordEncoder.encode(password);
        User user = User.builder()
                .email(email)
                .username(username)
                .firstName(name)
                .password(encryptedPassword)
                .role(UserRoleEnum.USER)
                .registerDate(LocalDate.now())
                .rating(0.0)
                .build();
        userRepository.save(user);
        String token = "accessToken : " + this.login(email, password);
        String response = "Email : " + user.getEmail() + "\n"
                + "Username: " + user.getUsername() + "\n"
                + "First Name: " + user.getFirstName() + "\n"
                + token;
        return response;

    }

    public String login(String email, String password) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenProvider.generateAccessToken((User) authUser.getPrincipal());
        return accessToken;
    }
}
