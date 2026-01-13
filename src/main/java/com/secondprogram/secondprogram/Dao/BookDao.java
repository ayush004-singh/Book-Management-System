package com.secondprogram.secondprogram.Dao;

import java.util.List;
import com.secondprogram.secondprogram.Model.Book;

public interface BookDao {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book addBook(Book book);
    Book updateBook(int id, Book book);
    String deleteBook(int id);
}
