package com.junny.eventsBeltReviewer.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.eventsBeltReviewer.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findAll();
	List<Event> findByState(String state);
	List<Event> findByStateNotContaining(String state);
}