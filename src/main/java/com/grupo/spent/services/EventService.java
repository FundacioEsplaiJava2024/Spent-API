package com.grupo.spent.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.grupo.spent.entities.Event;

public interface EventService {
    Event createEvent (String title, LocalDate data, LocalTime startTime, LocalTime endTime, Integer numParticipants, String address);
    List<Event> getAllEvents();
    Event getEventById(Integer id);
    void deleteEvent(Integer id);
    Event editEvent (Integer id, String title, LocalDate date, LocalTime startTime, LocalTime endTime, Integer numParticipants, String address);
}
