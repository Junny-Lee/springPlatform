package com.junny.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junny.languages.models.Language;
import com.junny.languages.services.LanguageService;

@Controller
public class LanguagesController {
	 private final LanguageService languageService;
	 
	 public LanguagesController(LanguageService languageService) {
	     this.languageService = languageService;
	 }
	 
	 @RequestMapping("/languages") // READ ALL
	 public String index(Model model) {
	     List<Language> languages = languageService.allLanguages();
	     model.addAttribute("languages", languages);
	     model.addAttribute("language", new Language()); // allows form to be on the same page
	     return "/languages/index.jsp";
	 }
	 
//	 @RequestMapping("/languages/new") // CREATE
//	 public String newLanguage(@ModelAttribute("language") Language language) {
//	     return "/languages/new.jsp";
//	 }
	 
	 @RequestMapping(value="/languages", method=RequestMethod.POST) // NEW
	 public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
	     if (result.hasErrors()) {
	    	 List<Language> languages = languageService.allLanguages(); // this shows the table
	    	 model.addAttribute("languages", languages);
	         return "/languages/index.jsp";
	     } else {
	         languageService.createLanguage(language);
	         return "redirect:/languages";
	     }
	 }
	 
	 @RequestMapping("/languages/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Language language = languageService.findLanguage(id);
		 model.addAttribute("language", language);
		 return "/languages/show.jsp";
	 }
	 
	 @RequestMapping("/languages/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Language language = languageService.findLanguage(id);
	     model.addAttribute("language", language);
	     return "/languages/edit.jsp";
	 }
	 
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/languages/edit.jsp";
	     } else {
	    	 languageService.updateLanguage(language);
	         return "redirect:/languages";
	     }
	 }
	 
//	 @RequestMapping(value="/languages/{id}/delete", method=RequestMethod.DELETE) // delete
	 @RequestMapping(value="/languages/{id}/delete") // delete
	 public String destroy(@PathVariable("id") Long id) {
	     languageService.deleteLanguage(id);
	     return "redirect:/languages";
	 }
 
}

