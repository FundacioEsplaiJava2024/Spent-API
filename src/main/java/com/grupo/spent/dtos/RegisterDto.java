package com.grupo.spent.dtos;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String username;
    private String password;
    private String name;
}
