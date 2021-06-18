package com.junny.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
}

