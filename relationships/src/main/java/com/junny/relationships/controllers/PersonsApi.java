package com.junny.relationships.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.relationships.models.Person;
import com.junny.relationships.services.PersonService;

@RestController
public class PersonsApi {
 private final PersonService personService; // backend. think of it like a const variable (won't change)
 public PersonsApi(PersonService personService){
     this.personService = personService;
 }
 @RequestMapping("/api/persons") // create routes
 public List<Person> index() {
     return personService.allPersons(); // calling on functions from PersonService.java (calling from back-end)
 }
 
 @RequestMapping(value="/api/persons", method=RequestMethod.POST)
 public Person create(@RequestParam(value="firstName") String firstName, 
 		@RequestParam(value="lastName") String lastName){
     Person person = new Person(firstName, lastName); // creating/instantiating a new Person according to the Person Model
     return personService.createPerson(person); // calling on functions from PersonService.java (calling from back-end)
 }
 
 @RequestMapping("/api/persons/{id}")
 public Person show(@PathVariable("id") Long id) {
     Person person = personService.findPerson(id); // calling on functions from PersonService.java (calling from back-end)
     return person;
 }
 
 @RequestMapping(value="/api/persons/{id}", method=RequestMethod.PUT)
 public Person update(@PathVariable("id") Long id, 
 		@RequestParam(value="firstName") String firstName, 
 		@RequestParam(value="lastName") String lastName){
     Person person = personService.updatePerson(id, firstName, lastName);
     return person;
 }
 
 @RequestMapping(value="/api/persons/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     personService.deletePerson(id);
 }

}


