package com.junny.productsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.productsAndCategories.models.Category;
import com.junny.productsAndCategories.models.Product;
import com.junny.productsAndCategories.services.CategoryService;
import com.junny.productsAndCategories.services.ProductService;

@Controller
public class CategoriesController {
	 private final CategoryService categoryService;
	 private final ProductService productService;
	 
	 public CategoriesController(CategoryService categoryService, ProductService productService) {
	     this.categoryService = categoryService;
	     this.productService = productService;
	 }
	 
	 @RequestMapping("/categories") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Category> categories = categoryService.allCategories();
	     model.addAttribute("categories", categories);
	     return "/categories/index.jsp";
	 }

	 @RequestMapping("/categories/new") // CREATE
	 public String newCategory(@ModelAttribute("category") Category category) {
	     return "/categories/new.jsp";
	 }

	 @RequestMapping(value="/categories", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/categories/new.jsp";
	     } else {
	         categoryService.createCategory(category);
	         return "redirect:/categories";
	     }
	 }
	 
	 // added this method 
	 // adds additional category to existing product
	 @RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	 public String addProduct(@PathVariable("id") Long id,
			 					@RequestParam("products") Long prodId ) {
		 Category category = categoryService.findCategory(id);
		 Product product = productService.findProduct(prodId);
		 category.getProducts().add(product);
		 categoryService.createCategory(category);
		 return "redirect:/categories/" + category.getId();	// look at this!!!!!!
	 }	 
	 
	 
	 @RequestMapping("/categories/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Category category = categoryService.findCategory(id);
		 List<Product> availableProd = productService.notMatchedProducts(category);
		 model.addAttribute("category", category);
		 model.addAttribute("availableProd", availableProd);
		 return "/categories/show.jsp";
	 }
	 
	 @RequestMapping("/categories/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Category category = categoryService.findCategory(id);
	     model.addAttribute("category", category);
	     return "/categories/edit.jsp";
	 }
	 
	 @RequestMapping(value="/categories/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("category") Category category, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/categories/edit.jsp";
	     } else {
	         categoryService.updateCategory(category);
	         return "redirect:/categories";
	     }
	 }
	 
	 @RequestMapping(value="/categories/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     categoryService.deleteCategory(id);
	     return "redirect:/categories";
	 }
 
}



