package com.grupo.spent.dtos;

import java.sql.Date;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CreateEventDto {
    private String title;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numParticipants;
    private String adress;
}
