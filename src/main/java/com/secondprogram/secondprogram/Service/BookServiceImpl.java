package com.secondprogram.secondprogram.Service;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.secondprogram.secondprogram.Model.Book;

@Service
public class BookServiceImpl implements BookService {

    
    @SuppressWarnings("FieldMayBeFinal")
    private Map<Integer,Book> bookMap = new HashMap<>();
    private int bookid=0;


    @Override
    public Map<Integer, Book> getAllBooks() {
        return bookMap;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book existingBook = bookMap.get(id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            bookMap.put(id, existingBook);
            return existingBook;
        } else {
            return null; // Or handle the case where the book doesn't exist
        }

    }

    @Override
    public String deleteBook(int id) {
         if (!bookMap.containsKey(id)) {
            return "Book with ID " + id + " not found.";
        }
        bookMap.remove(id);
        return "Book with ID " + id + " deleted.";

    }

    @Override
    public Book addBook(Book book) {
        book.setId(generateBookId());
        bookMap.put(book.getId(),book);
        return book;
    }

    @Override
    public Book getBookById(int id) {
        return bookMap.get(id);
    }

    private int generateBookId() {
        return bookid++;
    }
    
}
