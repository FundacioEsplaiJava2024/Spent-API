package com.grupo.spent.dtos.requests;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateEventDto {

    @NotEmpty(message = "Title is mandatory")
    @NotNull(message = "Title is mandatory")
    @Size(min = 6, max = 40, message = "Title should be between 6 and 40 characters")
    private String title;

    @NotEmpty(message = "Description is mandatory")
    @NotNull(message = "Description is mandatory")
    @Size(min = 10, max = 140, message = "Description should be between 10 and 140 characters")
    private String description;

    @NotNull(message = "Date is mandatory")
    private LocalDate date;

    @NotNull(message = "Start time is mandatory")
    private LocalTime startTime;

    private LocalTime endTime;

    @Max(value = 50, message = "Maximum number of participants is 50")
    @Min(value = 2, message = "Minimum number of participants is 2")
    private Integer numParticipants;

    @NotEmpty(message = "Address is mandatory")
    @NotNull(message = "Address is mandatory")
    @Size(min = 2, max = 30, message = "Address should be between 2 and 30 characters")
    private String address;

    @NotEmpty(message = "Sport name is mandatory")
    @NotNull(message = "Sport name is mandatory")
    private String sportName;
}
