package lv.unversityManagementSystem.service;


import lv.unversityManagementSystem.exception.DataWithThisIdNotFoundException;
import lv.unversityManagementSystem.model.Event;
import lv.unversityManagementSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        event.setEventCode(UUID.randomUUID().toString());
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event findEventById(Long id) {
        return eventRepository.findEventById(id).orElseThrow(() -> new DataWithThisIdNotFoundException("Event" +
                " by id " + id + " was not found!"));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteEventById(id);
    }


}
