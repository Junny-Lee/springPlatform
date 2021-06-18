package com.junny.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.productsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
//	List<Product> findByCategoryNotContains(Category c);
}