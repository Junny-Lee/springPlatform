package com.junny.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.relationships.models.Person;
import com.junny.relationships.repositories.PersonRepository;

@Service
public class PersonService {
 // adding the person repository as a dependency
 private final PersonRepository personRepository;
 
 public PersonService(PersonRepository personRepository) {
     this.personRepository = personRepository;
 }
 // returns all the persons
 public List<Person> allPersons() {
     return personRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // creates a person
 public Person createPerson(Person p) {
     return personRepository.save(p); // save() fn from extending from Crud
 }
 // retrieves a person
 public Person findPerson(Long id) {
     Optional<Person> optionalPerson = personRepository.findById(id); // Optional is saying "if it is here, i'll get you the person"
     if(optionalPerson.isPresent()) {
         return optionalPerson.get();
     } else {
         return null;
     }
 }
 // updates a person
 public Person updatePerson(Long id, String firstName, String lastName) {
 	Person person = findPerson(id);
 	person.setFirstName(firstName);
 	person.setLastName(lastName);
 	return personRepository.save(person);
 }
 
 public Person updatePerson(Person p) {
 	return personRepository.save(p);
 }
 
 // deletes a person
 public void deletePerson(Long id) {
 	personRepository.deleteById(id);
 }
}
