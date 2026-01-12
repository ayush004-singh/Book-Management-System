package com.secondprogram.secondprogram.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondprogram.secondprogram.Model.Book;
import com.secondprogram.secondprogram.Service.BookService;


@RestController //Recieve Calls from the client | --> Forward to Service Layer
@RequestMapping("books")
public class BookController { 

// //Object of Service Layer--> In jvm
// BookService bookservice = new BookServiceImpl();


//Object of Service Layer--> In Spring Container by Spring IOC | Dependency Injection by autowiring

@Autowired
BookService bookservice;

// Getting all books
@SuppressWarnings("rawtypes")
@GetMapping
public Map getAllBooks() {
    return bookservice.getAllBooks();
}

// Getting book by id
@GetMapping("/{id}")
public Book getBookById(@PathVariable int id) {
    return bookservice.getBookById(id);
}

// Add new book
@PostMapping
 public Book addBook(@RequestBody Book book) {
    return bookservice.addBook(book);
}

//Delete book
@DeleteMapping("/{id}")
public String deletebook(@PathVariable int id){
    return bookservice.deleteBook(id);
}

//Edit book
@PutMapping("/{id}")
public Book updateBook(@PathVariable int id, @RequestBody Book book){
    return bookservice.updateBook(id, book);
}

}
