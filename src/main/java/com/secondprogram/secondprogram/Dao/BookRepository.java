package com.secondprogram.secondprogram.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.secondprogram.secondprogram.Model.Book;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get all books
    public List<Book> getAllBooks() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                return b;
            }
        });
    }

    // Get book by id
    public Book getBookById(int id) {
        String sql = "select * from book where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                return b;
            }
        }, id);
    }

    // Add book
    public int addBook(Book book) {
        String sql = "insert into book(title, author) values(?, ?)";
        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());
    }

    // Update book
    public int updateBook(int id, Book book) {
        String sql = "update book set title=?, author=? where id=?";
        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), id);
    }

    // Delete book
    public int deleteBook(int id) {
        String sql = "delete from book where id=?";
        return jdbcTemplate.update(sql, id);
    }
}
