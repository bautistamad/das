package ar.edu.ubp.das.event.events.controllers;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ubp.das.event.events.beans.ActivityBean;
import ar.edu.ubp.das.event.events.beans.EventAssistant;
import ar.edu.ubp.das.event.events.beans.EventsBean;
import ar.edu.ubp.das.event.events.repositories.EventsRepository;

@RestController
@RequestMapping(path = "/events", produces = (MediaType.APPLICATION_JSON_VALUE))

public class EventController {

    @Autowired
    EventsRepository repository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<EventsBean>> getEvents() {
        return new ResponseEntity<>(repository.getEvents(), HttpStatus.OK);
    }

    // @GetMapping(path="/{nroEvento}")
    // public ResponseEntity<EventsBean> getEvent() {
    // return new ResponseEntity<>(repository.getEvent(), HttpStatus.OK);
    // }

    @GetMapping(path = "/{nroEvento}")
    public ResponseEntity<List<EventsBean>> getEvent(@PathVariable("nroEvento") int nroEvento) {
        return new ResponseEntity<>(repository.getEvent(nroEvento), HttpStatus.OK);
    }

    @PostMapping(path = "/activity", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<List<ActivityBean>> getActivities(@RequestParam("nroEvento") Integer nroEvento) {
        return new ResponseEntity<>(repository.getActivities(nroEvento), HttpStatus.OK);
    }

    @PutMapping(path = "/assistant", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> insLocalidad(@RequestBody EventAssistant eventAssistant) {
        return new ResponseEntity<>(repository.insAssitant(eventAssistant), HttpStatus.CREATED);
    }

}