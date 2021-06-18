package com.junny.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.relationships.models.Person;
import com.junny.relationships.services.PersonService;

@Controller
public class PersonsController {
	 private final PersonService personService;
	 
	 public PersonsController(PersonService personService) {
	     this.personService = personService;
	 }
	 
	 @RequestMapping("/persons") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Person> persons = personService.allPersons();
	     model.addAttribute("persons", persons);
	     return "/persons/index.jsp";
	 }

	 @RequestMapping("/persons/new") // CREATE
	 public String newPerson(@ModelAttribute("person") Person person) {
	     return "/persons/new.jsp";
	 }

	 @RequestMapping(value="/persons", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/persons/new.jsp";
	     } else {
	         personService.createPerson(person);
	         return "redirect:/persons";
	     }
	 }
	 
	 @RequestMapping("/persons/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Person person = personService.findPerson(id);
		 model.addAttribute("person", person);
		 return "/persons/show.jsp";
	 }
	 
	 @RequestMapping("/persons/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Person person = personService.findPerson(id);
	     model.addAttribute("person", person);
	     return "/persons/edit.jsp";
	 }
	 
	 @RequestMapping(value="/persons/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/persons/edit.jsp";
	     } else {
	         personService.updatePerson(person);
	         return "redirect:/persons";
	     }
	 }
	 
	 @RequestMapping(value="/persons/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     personService.deletePerson(id);
	     return "redirect:/persons";
	 }
 
}


