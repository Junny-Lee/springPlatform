package com.junny.dojosAndNinjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.dojosAndNinjas.models.Dojo;
import com.junny.dojosAndNinjas.services.DojoService;

@RestController
public class DojosApi {
 private final DojoService dojoService; // backend. think of it like a const variable (won't change)
 public DojosApi(DojoService dojoService){
     this.dojoService = dojoService;
 }
 @RequestMapping("/api/dojos") // create routes
 public List<Dojo> index() {
     return dojoService.allDojos(); // calling on functions from DojoService.java (calling from back-end)
 }
 
 @RequestMapping(value="/api/dojos", method=RequestMethod.POST)
 public Dojo create(@RequestParam(value="name") String name){
     Dojo dojo = new Dojo(name); // creating/instantiating a new Dojo according to the Dojo Model
     return dojoService.createDojo(dojo); // calling on functions from DojoService.java (calling from back-end)
 }
 
 @RequestMapping("/api/dojos/{id}")
 public Dojo show(@PathVariable("id") Long id) {
     Dojo dojo = dojoService.findDojo(id); // calling on functions from DojoService.java (calling from back-end)
     return dojo;
 }
 
 @RequestMapping(value="/api/dojos/{id}", method=RequestMethod.PUT)
 public Dojo update(@PathVariable("id") Long id, 
 		@RequestParam(value="name") String name){
     Dojo dojo = dojoService.updateDojo(id, name);
     return dojo;
 }
 
 @RequestMapping(value="/api/dojos/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     dojoService.deleteDojo(id);
 }

}



