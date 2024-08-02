package com.grupo.spent.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import com.grupo.spent.entities.Event;

public interface EventService {
    Event createEvent (String title, Date data, LocalTime startTime, LocalTime endTime, Integer numParticipants, String adress);
    List<Event> getAllEvents();
}
