package com.grupo.spent.dtos.requests;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateEventDto {

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 6, max = 40, message = "Password should be 8 characters long minimum")
    private String title;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 10, max = 140, message = "Password should be 8 characters long minimum")
    private String description;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numParticipants;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 2, max = 30, message = "Password should be 8 characters long minimum")
    private String address;
    private String sportName;
}
