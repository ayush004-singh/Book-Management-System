package com.secondprogram.BookManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondprogram.BookManagement.Dao.BookDaoImpl;
import com.secondprogram.BookManagement.Model.Book;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDaoImpl myRepo;

    @Override
    public List<Book> getAllBooks() {
        return myRepo.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return myRepo.getBookById(id);
    }

    @Override
    public Book addBook(Book book) {
        myRepo.addBook(book);
        return book;
    }

    @Override
    public Book updateBook(int id, Book book) {
        myRepo.updateBook(id, book);
        return myRepo.getBookById(id);
    }

    @Override
    public String deleteBook(int id) {
        myRepo.deleteBook(id);
        return "Book deleted successfully";
    }
}
