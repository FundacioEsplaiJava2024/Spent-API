package com.grupo.spent.dtos.requests;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import lombok.Getter;

@Getter
public class EditEventDto {
    private Optional<String> title;
    private Optional<String> description;
    private Optional<LocalDate> date;
    private Optional<LocalTime> startTime;
    private Optional<LocalTime> endTime;
    private Optional<Integer> numParticipants;
    private Optional<String> address;

    public EditEventDto(
            Optional<String> title,
            Optional<String>description,
            Optional<LocalDate> date,
            Optional<LocalTime> startTime, Optional<LocalTime> endTime,
            Optional<Integer> numParticipants,
            Optional<String> address) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numParticipants = numParticipants;
        this.address = address;
    }
}
