package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Event;
import lv.unversityManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public String getAllEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);

        return "event/eventList.html";
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
        Event event = eventService.findEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping("/add")
    public List<Event> addEvent(@RequestBody Event event){
        eventService.save(event);
        List<Event> lst = new ArrayList<>();
        lst.add(event);
        return lst;
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEmployee(@RequestBody Event event) {
        Event updateEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}