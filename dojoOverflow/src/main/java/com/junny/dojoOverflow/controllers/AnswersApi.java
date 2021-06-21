package com.junny.dojoOverflow.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.dojoOverflow.models.Answer;
import com.junny.dojoOverflow.services.AnswerService;

@RestController
public class AnswersApi {
	 private final AnswerService answerService;
	 public AnswersApi(AnswerService answerService){
	     this.answerService = answerService;
	 }
	 @GetMapping("/api/answers") 
	 public List<Answer> index() {
	     return answerService.allAnswers(); 
	 }
	 
	 @RequestMapping(value="/api/answers", method=RequestMethod.POST)
	 public Answer create(@RequestParam(value="answer") String answer){
	     Answer a = new Answer(answer); // creating/instantiating a new Answer according to the Answer Model
	     return answerService.createAnswer(a);
	 }
	 
	 @RequestMapping("/api/answers/{id}")
	 public Answer show(@PathVariable("id") Long id) {
	     Answer a = answerService.findAnswer(id); 
	     return a;
	 }
	 
	 @RequestMapping(value="/api/answers/{id}", method=RequestMethod.PUT)
	 public Answer update(@PathVariable("id") Long id, 
	 		@RequestParam(value="answer") String answer){
	     Answer a = answerService.updateAnswer(id, answer);
	     return a;
	 }
	 
	 @RequestMapping(value="/api/answers/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     answerService.deleteAnswer(id);
	 }

}




