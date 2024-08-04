package com.grupo.spent.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CreateEventDto {
    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numParticipants;
    private String address;
}
