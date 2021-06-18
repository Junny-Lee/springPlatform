package com.junny.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.productsAndCategories.models.Category;
import com.junny.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
 // adding the category repository as a dependency
 private final CategoryRepository categoryRepository;
 
 public CategoryService(CategoryRepository categoryRepository) {
     this.categoryRepository = categoryRepository;
 }
 // returns all the categories
 public List<Category> allCategories() {
     return categoryRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // creates a category
 public Category createCategory(Category c) {
     return categoryRepository.save(c); // save() fn from extending from Crud
 }
 // retrieves a category
 public Category findCategory(Long id) {
     Optional<Category> optionalCategory = categoryRepository.findById(id); // Optional is saying "if it is here, i'll get you the category"
     if(optionalCategory.isPresent()) {
         return optionalCategory.get();
     } else {
         return null;
     }
 }
 // updates a category
 public Category updateCategory(Long id, String name) {
 	Category category = findCategory(id);
 	category.setName(name);
 	return categoryRepository.save(category);
 }
 
 public Category updateCategory(Category c) {
 	return categoryRepository.save(c);
 }
 
 // deletes a category
 public void deleteCategory(Long id) {
 	categoryRepository.deleteById(id);
 }
}



