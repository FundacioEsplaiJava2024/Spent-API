package com.grupo.spent.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {
    @Email(message = "Email is not well formatted")
    @NotEmpty(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    @Size(min = 5, max = 15, message = "Username should be 8 characters long minimum")
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 5, max = 15, message = "Password should be 8 characters long minimum")
    private String password;

    @NotEmpty(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(min = 1, max = 20, message = "Username should be 2 characters long minimum")
    private String name;
}
