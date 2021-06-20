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
public class ProductsController {
	 private final ProductService productService;
	 private final CategoryService categoryService;
	 
	 public ProductsController(ProductService productService, CategoryService categoryService) {
	     this.productService = productService;
	     this.categoryService = categoryService;
	 }
	 
	 @RequestMapping("/products") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Product> products = productService.allProducts();
	     model.addAttribute("products", products);
	     return "/products/index.jsp";
	 }

	 @RequestMapping("/products/new") // CREATE
	 public String newProduct(@ModelAttribute("product") Product product) {
	     return "/products/new.jsp";
	 }

	 @RequestMapping(value="/products", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/products/new.jsp";
	     } else {
	         productService.createProduct(product);
	         return "redirect:/products";
	     }
	 }
	 
	 // added this method 
	 // adds additional category to existing product
	 @RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	 public String addCategory(@PathVariable("id") Long id,
			 					@RequestParam("categories") Long categoryId ) {
		 Product product = productService.findProduct(id);
		 Category category = categoryService.findCategory(categoryId);
		 product.getCategories().add(category);
		 productService.createProduct(product);
		 return "redirect:/products/" + product.getId();	// look at this!!!!!!
	 }	 
	 
	 @RequestMapping("/products/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Product product = productService.findProduct(id);
		 List<Category> availableCat = categoryService.notMatchedCategories(product); // look at this line!!!! this is part of what allows us to get a list of categories that's not already associated with the prodcut 
		 model.addAttribute("product", product);
		 model.addAttribute("availableCat", availableCat);
		 return "/products/show.jsp";
	 }
	 
	 @RequestMapping("/products/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Product product = productService.findProduct(id);
	     model.addAttribute("product", product);
	     return "/products/edit.jsp";
	 }
	 
	 @RequestMapping(value="/products/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/products/edit.jsp";
	     } else {
	         productService.updateProduct(product);
	         return "redirect:/products";
	     }
	 }
	 
	 @RequestMapping(value="/products/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     productService.deleteProduct(id);
	     return "redirect:/products";
	 }
 
}


