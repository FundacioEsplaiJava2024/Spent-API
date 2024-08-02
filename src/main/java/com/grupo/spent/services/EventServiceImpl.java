package com.grupo.spent.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.spent.entities.Event;
import com.grupo.spent.repositories.EventRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent (String title, Date data, LocalTime startTime, LocalTime endTime, Integer numParticipants, String adress) {
        Event event = new Event();
        event.setTitle(title);
        event.setDate(data);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setNumParticipants(numParticipants);
        event.setAdress(adress);

        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
