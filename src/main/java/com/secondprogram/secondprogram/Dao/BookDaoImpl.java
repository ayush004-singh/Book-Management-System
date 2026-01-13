package com.secondprogram.secondprogram.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secondprogram.secondprogram.Model.Book;
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(
            "SELECT * FROM book",
            (rs, rowNum) -> new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author")
            )
        );
    }

    @Override
    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM book WHERE id=?",
            (rs, rowNum) -> new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author")
            ),
            id
        );
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update(
            "INSERT INTO book(title, author) VALUES (?, ?)",
            book.getTitle(),
            book.getAuthor()
        );
        return book;
    }

    @Override
    public String deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
        return "Deleted";
    }

    @Override
    public Book updateBook(int id, Book book) {
        jdbcTemplate.update(
            "UPDATE book SET title=?, author=? WHERE id=?",
            book.getTitle(),
            book.getAuthor(),
            id
        );
        return book;
    }
}
