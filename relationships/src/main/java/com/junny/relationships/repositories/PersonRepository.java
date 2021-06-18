package com.junny.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
}

