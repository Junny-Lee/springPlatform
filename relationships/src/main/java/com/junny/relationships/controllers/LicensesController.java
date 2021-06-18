package com.junny.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junny.relationships.models.License;
import com.junny.relationships.models.Person;
import com.junny.relationships.services.LicenseService;
import com.junny.relationships.services.PersonService;

@Controller
public class LicensesController {
	 private final LicenseService licenseService;
	 private final PersonService personService;
	 
	 public LicensesController(LicenseService licenseService, PersonService personService) {
	     this.licenseService = licenseService;
	     this.personService = personService;
	 }

	 
	 @RequestMapping("/licenses") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<License> licenses = licenseService.allLicenses();
	     model.addAttribute("licenses", licenses);
	     return "/licenses/index.jsp";
	 }

	 // get request
	 @RequestMapping("/licenses/new") // CREATE
	 public String newLicense(@ModelAttribute("license") License license, Model model) {
		 List<Person> persons = personService.allPersons();
		 model.addAttribute("persons", persons);
	     return "/licenses/new.jsp";
	 }
	 
	 // post request
	 @RequestMapping(value="/licenses", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
	     if (result.hasErrors()) {
//	    	 System.out.println(result.getFieldErrors());
	         return "/licenses/new.jsp";
	     } else {
	         licenseService.createLicense(license);
	         return "redirect:/licenses";
	     }
	 }
	 
	 @RequestMapping("/licenses/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 License license = licenseService.findLicense(id);
		 model.addAttribute("license", license);
		 return "/licenses/show.jsp";
	 }
	 
	 @RequestMapping("/licenses/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     License license = licenseService.findLicense(id);
	     model.addAttribute("license", license);
	     return "/licenses/edit.jsp";
	 }
	 
	 @RequestMapping(value="/licenses/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("license") License license, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/licenses/edit.jsp";
	     } else {
	         licenseService.updateLicense(license);
	         return "redirect:/licenses";
	     }
	 }
	 
	 @RequestMapping(value="/licenses/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     licenseService.deleteLicense(id);
	     return "redirect:/licenses";
	 }
 
}


