package com.junny.eventsBeltReviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.eventsBeltReviewer.models.Message;
import com.junny.eventsBeltReviewer.repositories.MessageRepository;

@Service
public class MessageService {
	 // adding the message repository as a dependency
	 private final MessageRepository messageRepository;
	 
	 public MessageService(MessageRepository messageRepository) {
	     this.messageRepository = messageRepository;
	 }
	 // returns all the messages
	 public List<Message> allMessages() {
	     return messageRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
	 }
	 // creates a message
	 public Message createMessage(Message n) {
	     return messageRepository.save(n); // save() fn from extending from Crud
	 }
	 // retrieves a message
	 public Message findMessage(Long id) {
	     Optional<Message> optionalMessage = messageRepository.findById(id); // Optional is saying "if it is here, i'll get you the message"
	     if(optionalMessage.isPresent()) {
	         return optionalMessage.get();
	     } else {
	         return null;
	     }
	 }
	 // updates a message
	 public Message updateMessage(Long id, String comment) {
	 	Message message = findMessage(id);
	 	return messageRepository.save(message);
	 }
	 
	 public Message updateMessage(Message n) {
	 	return messageRepository.save(n);
	 }
	 
	 // deletes a message
	 public void deleteMessage(Long id) {
	 	messageRepository.deleteById(id);
	 }
	 
	 // find messages by event
     public List<Message> findByEvent(Long id){
     	 return messageRepository.findByEvent(id);
     }
}




