package com.arquitecturajava.repositories.mappers;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.business.Chapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ChapterMapper implements RowMapper<Chapter>{

    @Override
    public Chapter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author(rs.getString("pk_id"), rs.getString("name"), rs.getInt("age"));
        Book book = new Book(rs.getString("pk_isbn"), rs.getString("title"), author);
        return new Chapter(rs.getString("pk_title"), rs.getInt("pages"), book);
    }
}