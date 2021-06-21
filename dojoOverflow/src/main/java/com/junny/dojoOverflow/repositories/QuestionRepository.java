package com.junny.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.dojoOverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
