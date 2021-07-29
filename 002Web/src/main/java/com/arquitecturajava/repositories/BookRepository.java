package com.arquitecturajava.repositories;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import java.util.List;

public interface BookRepository {
    
    Book selectWithChapters(Book book);
    
    List<Book> selectWithChapters();
    
    List<Book> select(Author fk_author);
    
    int insert(Book book);
    
    int delete(Book book);
    
    int deleteBooks(Author fk_author);
    
    int update(Book book);
    
    int updatePk_isbn(Book book, String pk_isbn);
    
    int updateTitle(Book book, String title);
    
    int updateAuthor(Book book, Author author);
}