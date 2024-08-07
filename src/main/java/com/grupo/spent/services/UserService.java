package com.grupo.spent.services;

import com.grupo.spent.entities.User;

public interface UserService {
    User register(String email, String username, String name, String password);
    String login(String email, String password);
    User findUserByUsername(String username);

}
