package com.junny.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.dojoOverflow.models.Question;
import com.junny.dojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
 // adding the question repository as a dependency
 private final QuestionRepository questionRepository;
 
 public QuestionService(QuestionRepository questionRepository) {
     this.questionRepository = questionRepository;
 }
 // returns all the questions
 public List<Question> allQuestions() {
     return questionRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 
 // had to add to body of this method for tags creation
 // creates a question
 public Question createQuestion(Question q) {
	 System.out.println("Saving object");
     return questionRepository.save(q); // save() fn from extending from Crud
 }
 // retrieves a question
 public Question findQuestion(Long id) {
     Optional<Question> optionalQuestion = questionRepository.findById(id); // Optional is saying "if it is here, i'll get you the question"
     if(optionalQuestion.isPresent()) {
         return optionalQuestion.get();
     } else {
         return null;
     }
 }
 // updates a question
 public Question updateQuestion(Long id, String question) {
 	Question q = findQuestion(id);
 	q.setMyQuestion(question);
 	return questionRepository.save(q);
 }
 
 public Question updateQuestion(Question q) {
 	return questionRepository.save(q);
 }
 
 // deletes a question
 public void deleteQuestion(Long id) {
 	questionRepository.deleteById(id);
 }
}



