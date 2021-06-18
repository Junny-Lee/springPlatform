package com.junny.productsAndCategories.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.productsAndCategories.models.Category;
import com.junny.productsAndCategories.services.CategoryService;

@RestController
public class CategoriesApi {
	 private final CategoryService categoryService; // backend. think of it like a const variable (won't change)
	 public CategoriesApi(CategoryService categoryService){
	     this.categoryService = categoryService;
	 }
	 @RequestMapping("/api/categories") // create routes
	 public List<Category> index() {
	     return categoryService.allCategories(); // calling on functions from CategoryService.java (calling from back-end)
	 }
	 
	 @RequestMapping(value="/api/categories", method=RequestMethod.POST)
	 public Category create(@RequestParam(value="name") String name){
	     Category category = new Category(name); // creating/instantiating a new Category according to the Category Model
	     return categoryService.createCategory(category); // calling on functions from CategoryService.java (calling from back-end)
	 }
	 
	 @RequestMapping("/api/categories/{id}")
	 public Category show(@PathVariable("id") Long id) {
	     Category category = categoryService.findCategory(id); // calling on functions from CategoryService.java (calling from back-end)
	     return category;
	 }
	 
	 @RequestMapping(value="/api/categories/{id}", method=RequestMethod.PUT)
	 public Category update(@PathVariable("id") Long id, 
	 		@RequestParam(value="name") String name){
	     Category category = categoryService.updateCategory(id, name);
	     return category;
	 }
	 
	 @RequestMapping(value="/api/categories/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     categoryService.deleteCategory(id);
	 }

}




