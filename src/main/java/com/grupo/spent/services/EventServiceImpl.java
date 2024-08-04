package com.grupo.spent.services;

import java.time.LocalDate;
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
    public Event createEvent (String title, LocalDate date, LocalTime startTime, LocalTime endTime, Integer numParticipants, String address) {
        Event event = new Event();
        event.setTitle(title);
        event.setDate(date);
        event.setStart_time(startTime);
        event.setEnd_time(endTime);
        event.setNum_participants(numParticipants);
        event.setAddress(address);

        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event editEvent (Integer id, String title, LocalDate data, LocalTime startTime, LocalTime endTime, Integer numParticipants, String address) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        existingEvent.setTitle(title);
        existingEvent.setDate(data);
        existingEvent.setStart_time(startTime);
        existingEvent.setEnd_time(endTime);
        existingEvent.setNum_participants(numParticipants);
        existingEvent.setAddress(address);

        return eventRepository.save(existingEvent);
    }

}
