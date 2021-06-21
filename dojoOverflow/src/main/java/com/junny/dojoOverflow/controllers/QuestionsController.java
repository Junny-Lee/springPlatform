package com.junny.dojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.dojoOverflow.models.Question;
import com.junny.dojoOverflow.services.QuestionService;

@Controller
public class QuestionsController {
	 private final QuestionService questionService;
	 
	 public QuestionsController(QuestionService questionService) {
	     this.questionService = questionService;;
	 }
	 
	 @RequestMapping("/")
	 public String home() {  
	     return "redirect:/questions";
	 }
	 
	 @RequestMapping("/questions") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Question> questions = questionService.allQuestions();
	     model.addAttribute("questions", questions);
	     return "/questions/index.jsp";
	 }

	 @RequestMapping("/questions/new") // CREATE
	 public String newQuestion(@ModelAttribute("question") Question question) { // q = the question object, not attribute
	     return "/questions/new.jsp";
	 }

	 @RequestMapping(value="/questions", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("question") Question question, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/questions/new.jsp";
	     } else {
	         questionService.createQuestion(question); // the object
	         return "redirect:/questions";
	     }
	 }
	 
	 @RequestMapping("/questions/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Question question = questionService.findQuestion(id);
		 model.addAttribute("question", question);
		 return "/questions/show.jsp";
	 }
	 
	 @RequestMapping("/questions/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Question question = questionService.findQuestion(id);
	     model.addAttribute("question", question);
	     return "/questions/edit.jsp";
	 }
	 
	 @RequestMapping(value="/questions/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("question") Question question, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/questions/edit.jsp";
	     } else {
	         questionService.updateQuestion(question);
	         return "redirect:/questions";
	     }
	 }
	 
	 @RequestMapping(value="/questions/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     questionService.deleteQuestion(id);
	     return "redirect:/questions";
	 }
 
}