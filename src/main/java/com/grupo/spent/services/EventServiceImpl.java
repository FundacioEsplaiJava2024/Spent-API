package com.grupo.spent.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.spent.entities.Event;
import com.grupo.spent.entities.Sport;
import com.grupo.spent.entities.User;
import com.grupo.spent.exceptions.NotFoundException;
import com.grupo.spent.repositories.EventRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(String title, String description, LocalDate date, LocalTime startTime, LocalTime endTime,
            Integer numParticipants, String address, Sport sport, User user) {

        Event event = new Event();
        event.setTitle(title);
        event.setDescription(description);
        event.setDate(date);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setNumParticipants(numParticipants);
        event.setAddress(address);
        event.setSport(sport);
        event.setUserCreator(user);
        event.setEventParticipants(new ArrayList<>());

        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer id) throws NotFoundException {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            throw new NotFoundException("Event not found with id: " + id);

        } else
            return event;
    }

    @Override
    public void deleteEvent(Integer id) {
        Event event = eventRepository.findById(id).orElse(null);
        event.getEventParticipants().clear();
        event.setUserCreator(null);
        event.setSport(null);
        eventRepository.save(event);
        eventRepository.deleteById(id);
    }

    @Override
    public Event editEvent(Integer id, String title, String description, LocalDate data, LocalTime startTime,
            LocalTime endTime,
            Integer numParticipants, String address) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        existingEvent.setTitle(title);
        existingEvent.setDescription(description);
        existingEvent.setDate(data);
        existingEvent.setStartTime(startTime);
        existingEvent.setEndTime(endTime);
        existingEvent.setNumParticipants(numParticipants);
        existingEvent.setAddress(address);

        return eventRepository.save(existingEvent);
    }

    public Event joinEvent(Event event, User user) {
        event.getEventParticipants().add(user);
        return eventRepository.save(event);
    }

    public Event withdrawEvent(Event event, User user) {
        for (int i = 0; i < event.getEventParticipants().size(); i++) {
            if (event.getEventParticipants().get(i).getId().equals(user.getId())) {
                event.getEventParticipants().remove(i);
                return eventRepository.save(event);
            }
        }
        return eventRepository.save(event);
    }
}