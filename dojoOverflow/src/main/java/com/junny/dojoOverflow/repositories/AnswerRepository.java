package com.junny.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.dojoOverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
}
