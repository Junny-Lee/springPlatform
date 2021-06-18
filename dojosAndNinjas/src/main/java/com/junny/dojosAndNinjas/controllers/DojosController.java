package com.junny.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junny.dojosAndNinjas.models.Dojo;
import com.junny.dojosAndNinjas.services.DojoService;

@Controller
public class DojosController {
	 private final DojoService dojoService;
	 
	 public DojosController(DojoService dojoService) {
	     this.dojoService = dojoService;
	 }
	 
	 @RequestMapping("/dojos") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Dojo> dojos = dojoService.allDojos();
	     model.addAttribute("dojos", dojos);
	     return "/dojos/index.jsp";
	 }

	 @RequestMapping("/dojos/new") // CREATE
	 public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
	     return "/dojos/new.jsp";
	 }

	 @RequestMapping(value="/dojos", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/dojos/new.jsp";
	     } else {
	         dojoService.createDojo(dojo);
	         return "redirect:/dojos";
	     }
	 }
	 
	 @RequestMapping("/dojos/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Dojo dojo = dojoService.findDojo(id);
		 model.addAttribute("dojo", dojo);
		 return "/dojos/show.jsp";
	 }
	 
	 @RequestMapping("/dojos/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Dojo dojo = dojoService.findDojo(id);
	     model.addAttribute("dojo", dojo);
	     return "/dojos/edit.jsp";
	 }
	 
	 @RequestMapping(value="/dojos/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/dojos/edit.jsp";
	     } else {
	         dojoService.updateDojo(dojo);
	         return "redirect:/dojos";
	     }
	 }
	 
	 @RequestMapping(value="/dojos/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     dojoService.deleteDojo(id);
	     return "redirect:/dojos";
	 }
 
}


