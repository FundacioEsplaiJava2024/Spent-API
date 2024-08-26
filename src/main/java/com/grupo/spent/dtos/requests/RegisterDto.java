package com.grupo.spent.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Size(min = 5, max = 15, message = "Username should be between 5 and 15 characters")
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 7, max = 20, message = "Password should be between 3 and 15 characters")
    @Pattern(regexp = "^(?=.*\\d).*$", message = "Password must contain at least one number")
    private String password;

    @NotEmpty(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(min = 2, max = 20, message = "Username should be between 2 and 20 characters")
    private String name;
}
