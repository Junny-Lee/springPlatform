// backend
// functions that exist within the book repository
package com.junny.mvc.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.junny.mvc.models.Book;
import com.junny.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b); // save() fn from extending from Crud
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id); // Optional is saying "if it is here, i'll get you the book"
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book book = findBook(id);
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	return bookRepository.save(book);
    }
    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}