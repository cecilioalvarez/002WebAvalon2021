package com.arquitecturajava.repositories.services;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import java.util.List;

public interface LibraryService {

    int delete(Book book);

    int delete(Author fk_author);

    int insert(Book book);

    List<Book> select(Author fk_author);

    Book selectWithChapters(Book book);

    List<Book> selectWithChapters();

    int update(Book book);

    int updateAuthor(Book book, Author author);

    int updatePk_isbn(Book book, String pk_isbn);

    int updateTitle(Book book, String title);
}