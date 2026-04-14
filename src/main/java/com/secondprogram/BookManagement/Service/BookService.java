package com.secondprogram.BookManagement.Service;

import java.util.List;

import com.secondprogram.BookManagement.Model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book addBook(Book book);
    Book updateBook(int id, Book book);
    String deleteBook(int id);
}