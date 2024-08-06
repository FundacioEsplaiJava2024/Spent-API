package com.grupo.spent.dtos;

public class RegisterResponseDto {
    private String email;
    private String username;
    private String firstName;
    private String accessToken;

    // Constructor, getters, and setters
    public RegisterResponseDto(String email, String username, String firstName, String accessToken) {
        this.email = email; 
        this.username = username;
        this.firstName = firstName;
        this.accessToken = accessToken;
    }

    // Getters and setters can be generated automatically with Lombok
    // @Getter @Setter
    // or manually if not using Lombok
}
