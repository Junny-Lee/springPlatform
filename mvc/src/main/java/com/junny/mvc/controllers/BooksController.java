package com.junny.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junny.mvc.models.Book;
import com.junny.mvc.services.BookService;

@Controller
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("/books") // READ ALL
 public String index(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
 }
 
 @RequestMapping("/books/new") // CREATE
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 
 @RequestMapping(value="/books", method=RequestMethod.POST) // NEW
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 
 @RequestMapping("/books/{id}") // READ ONE
 public String show(Model model, @PathVariable("id") Long id) {
	 Book book = bookService.findBook(id);
	 model.addAttribute("book", book);
	 return "/books/show.jsp";
 }
 
 @RequestMapping("/books/{id}/edit") // display jsp file 
 public String edit(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "/books/edit.jsp";
 }
 
 @RequestMapping(value="/books/{id}", method=RequestMethod.PUT) // actually doing the put
 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/edit.jsp";
     } else {
         bookService.updateBook(book);
         return "redirect:/books";
     }
 }
 
 @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE) // delete
 public String destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
     return "redirect:/books";
 }
 
}

