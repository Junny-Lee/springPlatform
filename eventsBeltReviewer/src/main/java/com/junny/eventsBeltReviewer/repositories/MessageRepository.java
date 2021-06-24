package com.junny.eventsBeltReviewer.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.eventsBeltReviewer.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	List<Message> findAll();
	List<Message> findByEvent(Long id);
}
