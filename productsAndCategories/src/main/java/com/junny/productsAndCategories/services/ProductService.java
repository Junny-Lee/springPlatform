package com.junny.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.productsAndCategories.models.Category;
import com.junny.productsAndCategories.models.Product;
import com.junny.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
 // adding the product repository as a dependency
 private final ProductRepository productRepository;
 
 public ProductService(ProductRepository productRepository) {
     this.productRepository = productRepository;
 }
 // returns all the products
 public List<Product> allProducts() {
     return productRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 
 // this is NEW!!!! from a new JPA Query in the Repository:
 public List<Product> notMatchedProducts(Category c) {
	 return productRepository.findByCategoriesNotContains(c);
 }
 
 // creates a product
 public Product createProduct(Product p) {
     return productRepository.save(p); // save() fn from extending from Crud
 }
 // retrieves a product
 public Product findProduct(Long id) {
     Optional<Product> optionalProduct = productRepository.findById(id); // Optional is saying "if it is here, i'll get you the product"
     if(optionalProduct.isPresent()) {
         return optionalProduct.get();
     } else {
         return null;
     }
 }
 // updates a product
 public Product updateProduct(Long id, String name, String description, float price) {
 	Product product = findProduct(id);
 	product.setName(name);
 	product.setDescription(description);
 	product.setPrice(price);
 	return productRepository.save(product);
 }
 
 public Product updateProduct(Product p) {
 	return productRepository.save(p);
 }
 
 // deletes a product
 public void deleteProduct(Long id) {
 	productRepository.deleteById(id);
 }
}


