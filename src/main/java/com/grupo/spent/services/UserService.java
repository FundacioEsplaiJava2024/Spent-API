package com.grupo.spent.services;

import com.grupo.spent.entities.User;
import com.grupo.spent.exceptions.NotFoundException;

public interface UserService {
    User register(String email, String username, String name, String password);

    String login(String email, String password);

    User findUserByUsername(String username) throws NotFoundException;

    User findUserByEmail(String email) throws NotFoundException;

    boolean existsUserByEmail(String email);
}
