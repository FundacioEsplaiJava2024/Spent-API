package com.grupo.spent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.spent.dtos.CreateEventDto;
import com.grupo.spent.services.EventService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("")
    public ResponseEntity<?> createEvent(@RequestBody CreateEventDto createEventDto) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(
            createEventDto.getTitle(),
            createEventDto.getDate(),
            createEventDto.getStartTime(),
            createEventDto.getEndTime(),
            createEventDto.getNumParticipants(),
            createEventDto.getAdress()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEvents());
    }
    
}
