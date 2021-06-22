package com.junny.eventsBeltReviewer.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.eventsBeltReviewer.models.Event;
import com.junny.eventsBeltReviewer.repositories.EventRepository;

@Service
public class EventService {
	 // adding the event repository as a dependency
	 private final EventRepository eventRepository;
	 
	 public EventService(EventRepository eventRepository) {
	     this.eventRepository = eventRepository;
	 }
	 // returns all the events
	 public List<Event> allEvents() {
	     return eventRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
	 }
	 // creates a event
	 public Event createEvent(Event n) {
	     return eventRepository.save(n); // save() fn from extending from Crud
	 }
	 // retrieves a event
	 public Event findEvent(Long id) {
	     Optional<Event> optionalEvent = eventRepository.findById(id); // Optional is saying "if it is here, i'll get you the event"
	     if(optionalEvent.isPresent()) {
	         return optionalEvent.get();
	     } else {
	         return null;
	     }
	 }
	 // updates a event
	 public Event updateEvent(Long id, String name, Date date, String location, String state) {
	 	Event event = findEvent(id);
	 	event.setName(name);
	 	event.setDate(date);
	 	event.setLocation(location);
	 	event.setState(state);
	 	return eventRepository.save(event);
	 }
	 
	 public Event updateEvent(Event n) {
	 	return eventRepository.save(n);
	 }
	 
	 // deletes a event
	 public void deleteEvent(Long id) {
	 	eventRepository.deleteById(id);
	 }
	 
     // find events by state
     public List<Event> findByState(String state){
     	 return eventRepository.findByState(state);
     }
    
     // find all other not including the passed in state
     public List<Event> findByStateNotContaining(String state){
    	 return eventRepository.findByStateNotContaining(state);
     }
}



