package com.grupo.spent.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.spent.dtos.CreateEventDto;
import com.grupo.spent.dtos.EditEventDto;
import com.grupo.spent.entities.Event;
import com.grupo.spent.services.EventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("")
    public ResponseEntity<?> createEvent(@RequestBody CreateEventDto createEventDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(
                createEventDto.getTitle(),
                createEventDto.getDate(),
                createEventDto.getStartTime(),
                createEventDto.getEndTime(),
                createEventDto.getNumParticipants(),
                createEventDto.getAddress()));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEvents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Event deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editEvent(@PathVariable Integer id, @RequestBody EditEventDto editEventDto) {
        Event event = eventService.getEventById(id);

        String title = editEventDto.getTitle().orElse(event.getTitle());
        LocalDate date = editEventDto.getDate().orElse(event.getDate());
        LocalTime startTime = editEventDto.getStartTime().orElse(event.getStartTime());
        LocalTime endTime = editEventDto.getEndTime().orElse(event.getEndTime());
        Integer numParticipants = editEventDto.getNumParticipants().orElse(event.getNumParticipants());
        String address = editEventDto.getAddress().orElse(event.getAddress());

        return ResponseEntity.status(HttpStatus.OK)
                .body(eventService.editEvent(id, title, date, startTime, endTime, numParticipants, address));
    }
}
