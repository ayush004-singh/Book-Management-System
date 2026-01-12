 package com.secondprogram.secondprogram.Service;

import java.util.Map;

import com.secondprogram.secondprogram.Model.Book;

public interface BookService {
    
    Map<Integer, Book> getAllBooks();
    Book updateBook(int id, Book book);
    String deleteBook(int id);
    Book addBook(Book book);
    Book getBookById(int id);
    
}