package com.junny.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.dojosAndNinjas.models.Ninja;
import com.junny.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
 // adding the ninja repository as a dependency
 private final NinjaRepository ninjaRepository;
 
 public NinjaService(NinjaRepository ninjaRepository) {
     this.ninjaRepository = ninjaRepository;
 }
 // returns all the ninjas
 public List<Ninja> allNinjas() {
     return ninjaRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // creates a ninja
 public Ninja createNinja(Ninja n) {
     return ninjaRepository.save(n); // save() fn from extending from Crud
 }
 // retrieves a ninja
 public Ninja findNinja(Long id) {
     Optional<Ninja> optionalNinja = ninjaRepository.findById(id); // Optional is saying "if it is here, i'll get you the ninja"
     if(optionalNinja.isPresent()) {
         return optionalNinja.get();
     } else {
         return null;
     }
 }
 // updates a ninja
 public Ninja updateNinja(Long id, String firstName, String lastName, int age) {
 	Ninja ninja = findNinja(id);
 	ninja.setFirstName(firstName);
 	ninja.setLastName(lastName);
 	ninja.setAge(age);
 	return ninjaRepository.save(ninja);
 }
 
 public Ninja updateNinja(Ninja n) {
 	return ninjaRepository.save(n);
 }
 
 // deletes a ninja
 public void deleteNinja(Long id) {
 	ninjaRepository.deleteById(id);
 }
}


