package com.junny.dojosAndNinjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.dojosAndNinjas.models.Ninja;
import com.junny.dojosAndNinjas.services.NinjaService;

@RestController
public class NinjasApi {
 private final NinjaService ninjaService; // backend. think of it like a const variable (won't change)
 public NinjasApi(NinjaService ninjaService){
     this.ninjaService = ninjaService;
 }
 @RequestMapping("/api/ninjas") // create routes
 public List<Ninja> index() {
     return ninjaService.allNinjas(); // calling on functions from NinjaService.java (calling from back-end)
 }
 
 @RequestMapping(value="/api/ninjas", method=RequestMethod.POST)
 public Ninja create(@RequestParam(value="firstName") String firstName,
		 			@RequestParam(value="lastName") String lastName,
		 			@RequestParam(value="age") int age){
     Ninja ninja = new Ninja(firstName, lastName, age); // creating/instantiating a new Ninja according to the Ninja Model
     return ninjaService.createNinja(ninja); // calling on functions from NinjaService.java (calling from back-end)
 }
 
 @RequestMapping("/api/ninjas/{id}")
 public Ninja show(@PathVariable("id") Long id) {
     Ninja ninja = ninjaService.findNinja(id); // calling on functions from NinjaService.java (calling from back-end)
     return ninja;
 }
 
 @RequestMapping(value="/api/ninjas/{id}", method=RequestMethod.PUT)
 public Ninja update(@PathVariable("id") Long id, 
 		@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="age") int age){
     Ninja ninja = ninjaService.updateNinja(id, firstName, lastName, age);
     return ninja;
 }
 
 @RequestMapping(value="/api/ninjas/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     ninjaService.deleteNinja(id);
 }

}




