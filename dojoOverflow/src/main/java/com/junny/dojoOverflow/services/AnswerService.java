package com.junny.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.dojoOverflow.models.Answer;
import com.junny.dojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
 // adding the answer repository as a dependency
 private final AnswerRepository answerRepository;
 
 public AnswerService(AnswerRepository answerRepository) {
     this.answerRepository = answerRepository;
 }
 // returns all the answers
 public List<Answer> allAnswers() {
     return answerRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 
 // creates a answer
 public Answer createAnswer(Answer a) {
     return answerRepository.save(a); // save() fn from extending from Crud
 }
 // retrieves a answer
 public Answer findAnswer(Long id) {
     Optional<Answer> optionalAnswer = answerRepository.findById(id); // Optional is saying "if it is here, i'll get you the answer"
     if(optionalAnswer.isPresent()) {
         return optionalAnswer.get();
     } else {
         return null;
     }
 }
 // updates a answer
 public Answer updateAnswer(Long id, String answer) {
 	Answer a = findAnswer(id);
 	a.setAnswer(answer);
 	return answerRepository.save(a);
 }
 
 public Answer updateAnswer(Answer a) {
 	return answerRepository.save(a);
 }
 
 // deletes a answer
 public void deleteAnswer(Long id) {
 	answerRepository.deleteById(id);
 }
}



