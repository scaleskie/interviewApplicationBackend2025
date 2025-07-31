package sam.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sam.example.demo.repositories.EventRepository;
import sam.example.demo.Event;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/allEvents")
    @ResponseBody
    public List<Event> listAll() {
        return eventRepository.findAll();
    }


}