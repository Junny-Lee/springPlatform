package com.junny.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.dojosAndNinjas.models.Dojo;
import com.junny.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
 // adding the dojo repository as a dependency
 private final DojoRepository dojoRepository;
 
 public DojoService(DojoRepository dojoRepository) {
     this.dojoRepository = dojoRepository;
 }
 // returns all the dojos
 public List<Dojo> allDojos() {
     return dojoRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // creates a dojo
 public Dojo createDojo(Dojo d) {
     return dojoRepository.save(d); // save() fn from extending from Crud
 }
 // retrieves a dojo
 public Dojo findDojo(Long id) {
     Optional<Dojo> optionalDojo = dojoRepository.findById(id); // Optional is saying "if it is here, i'll get you the dojo"
     if(optionalDojo.isPresent()) {
         return optionalDojo.get();
     } else {
         return null;
     }
 }
 // updates a dojo
 public Dojo updateDojo(Long id, String name) {
 	Dojo dojo = findDojo(id);
 	dojo.setName(name);
 	return dojoRepository.save(dojo);
 }
 
 public Dojo updateDojo(Dojo d) {
 	return dojoRepository.save(d);
 }
 
 // deletes a dojo
 public void deleteDojo(Long id) {
 	dojoRepository.deleteById(id);
 }
}

