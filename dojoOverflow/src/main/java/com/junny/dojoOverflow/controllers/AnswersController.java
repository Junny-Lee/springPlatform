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

import com.junny.dojoOverflow.models.Answer;
import com.junny.dojoOverflow.services.AnswerService;

@Controller
public class AnswersController {
	 private final AnswerService answerService;
	 
	 public AnswersController(AnswerService answerService) {
	     this.answerService = answerService;;
	 }
	 
	 @RequestMapping("/answers") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Answer> answers = answerService.allAnswers();
	     model.addAttribute("answers", answers);
	     return "/answers/index.jsp";
	 }

	 @RequestMapping("/answers/new") // CREATE
	 public String newAnswer(@ModelAttribute("answer") Answer answer) {
	     return "/answers/new.jsp";
	 }

	 @RequestMapping(value="/answers", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/answers/new.jsp";
	     } else {
	         answerService.createAnswer(answer);
	         return "redirect:/answers";
	     }
	 }
	 
	 @RequestMapping("/answers/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Answer answer = answerService.findAnswer(id);
		 model.addAttribute("answer", answer);
		 return "/answers/show.jsp";
	 }
	 
	 @RequestMapping("/answers/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Answer answer = answerService.findAnswer(id);
	     model.addAttribute("answer", answer);
	     return "/answers/edit.jsp";
	 }
	 
	 @RequestMapping(value="/answers/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/answers/edit.jsp";
	     } else {
	         answerService.updateAnswer(answer);
	         return "redirect:/answers";
	     }
	 }
	 
	 @RequestMapping(value="/answers/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     answerService.deleteAnswer(id);
	     return "redirect:/answers";
	 }
 
}