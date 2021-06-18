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
import com.junny.dojosAndNinjas.models.Ninja;
import com.junny.dojosAndNinjas.services.DojoService;
import com.junny.dojosAndNinjas.services.NinjaService;

@Controller
public class NinjasController {
	 private final NinjaService ninjaService;
	 private final DojoService dojoService;
	 
	 public NinjasController(NinjaService ninjaService, DojoService dojoService) {
	     this.ninjaService = ninjaService;
	     this.dojoService = dojoService;
	 }
	 
	 @RequestMapping("/ninjas") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Ninja> ninjas = ninjaService.allNinjas();
	     model.addAttribute("ninjas", ninjas);
	     return "/ninjas/index.jsp";
	 }

	 @RequestMapping("/ninjas/new") // CREATE
	 public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		 List<Dojo> dojos = dojoService.allDojos();
		 model.addAttribute("dojos", dojos);
	     return "/ninjas/new.jsp";
	 }

	 @RequestMapping(value="/ninjas", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/ninjas/new.jsp";
	     } else {
	         ninjaService.createNinja(ninja);
	         return "redirect:/ninjas";
	     }
	 }
	 
	 @RequestMapping("/ninjas/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Ninja ninja = ninjaService.findNinja(id);
		 model.addAttribute("ninja", ninja);
		 return "/ninjas/show.jsp";
	 }
	 
	 @RequestMapping("/ninjas/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Ninja ninja = ninjaService.findNinja(id);
	     model.addAttribute("ninja", ninja);
	     return "/ninjas/edit.jsp";
	 }
	 
	 @RequestMapping(value="/ninjas/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/ninjas/edit.jsp";
	     } else {
	         ninjaService.updateNinja(ninja);
	         return "redirect:/ninjas";
	     }
	 }
	 
	 @RequestMapping(value="/ninjas/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     ninjaService.deleteNinja(id);
	     return "redirect:/ninjas";
	 }
 
}


