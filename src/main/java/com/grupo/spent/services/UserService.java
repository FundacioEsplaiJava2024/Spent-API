package com.grupo.spent.services;

public interface UserService {
    String register(String email, String username, String name, String password);
    String login(String email, String password);

}
