package com.junny.dojoOverflow.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.dojoOverflow.models.Question;
import com.junny.dojoOverflow.services.QuestionService;

@RestController
public class QuestionsApi {
	 private final QuestionService questionService;
	 public QuestionsApi(QuestionService questionService){
	     this.questionService = questionService;
	 }
	 @GetMapping("/api/questions") 
	 public List<Question> index() {
	     return questionService.allQuestions(); 
	 }
	 
	 @RequestMapping(value="/api/questions", method=RequestMethod.POST)
	 public Question create(@RequestParam(value="myQuestion") String myQuestion){
	     Question q = new Question(myQuestion); // creating/instantiating a new Question according to the Question Model
	     return questionService.createQuestion(q);
	 }
	 
	 @RequestMapping("/api/questions/{id}")
	 public Question show(@PathVariable("id") Long id) {
	     Question q = questionService.findQuestion(id); 
	     return q;
	 }
	 
	 @RequestMapping(value="/api/questions/{id}", method=RequestMethod.PUT)
	 public Question update(@PathVariable("id") Long id, 
	 		@RequestParam(value="myQuestion") String myQuestion){
	     Question q = questionService.updateQuestion(id, myQuestion);
	     return q;
	 }
	 
	 @RequestMapping(value="/api/questions/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     questionService.deleteQuestion(id);
	 }

}




