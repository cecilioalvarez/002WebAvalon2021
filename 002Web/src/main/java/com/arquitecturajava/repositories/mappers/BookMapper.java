package com.arquitecturajava.repositories.mappers;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getString("pk_isbn"), rs.getString("title"), new Author(rs.getString("fk_author"), rs.getString("name"), rs.getInt("age")));
    }
}