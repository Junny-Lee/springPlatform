package com.junny.productsAndCategories.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.productsAndCategories.models.Product;
import com.junny.productsAndCategories.services.ProductService;

@RestController
public class ProductsApi {
	 private final ProductService productService; // backend. think of it like a const variable (won't change)
	 public ProductsApi(ProductService productService){
	     this.productService = productService;
	 }
	 @RequestMapping("/api/products") // create routes
	 public List<Product> index() {
	     return productService.allProducts(); // calling on functions from ProductService.java (calling from back-end)
	 }
	 
	 @RequestMapping(value="/api/products", method=RequestMethod.POST)
	 public Product create(@RequestParam(value="name") String name,
			 @RequestParam(value="description") String description,
			 @RequestParam(value="price") float price){
	     Product product = new Product(name, description, price); // creating/instantiating a new Product according to the Product Model
	     return productService.createProduct(product); // calling on functions from ProductService.java (calling from back-end)
	 }
	 
	 @RequestMapping("/api/products/{id}")
	 public Product show(@PathVariable("id") Long id) {
	     Product product = productService.findProduct(id); // calling on functions from ProductService.java (calling from back-end)
	     return product;
	 }
	 
	 @RequestMapping(value="/api/products/{id}", method=RequestMethod.PUT)
	 public Product update(@PathVariable("id") Long id, 
	 		@RequestParam(value="name") String name,
			 @RequestParam(value="description") String description,
			 @RequestParam(value="price") float price){
	     Product product = productService.updateProduct(id, name, description, price);
	     return product;
	 }
	 
	 @RequestMapping(value="/api/products/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     productService.deleteProduct(id);
	 }

}




