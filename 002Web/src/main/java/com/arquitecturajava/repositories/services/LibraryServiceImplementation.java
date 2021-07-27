package com.arquitecturajava.repositories.services;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.repositories.BookRepository;
import java.util.List;

public class LibraryServiceImplementation implements LibraryService {

    private BookRepository bookRepository;
    
    public LibraryServiceImplementation(BookRepository repository) {
        this.bookRepository = repository;
    }

    @Override
    public Book selectWithChapters(Book book) {
        return this.bookRepository.selectWithChapters(book);
    }

    @Override
    public List<Book> selectWithChapters() {
        return this.bookRepository.selectWithChapters();
    }

    @Override
    public List<Book> select(Author fk_author) {
        return this.bookRepository.select(fk_author);
    }

    @Override
    public int insert(Book book) {
        return this.bookRepository.insert(book);
    }

    @Override
    public int delete(Book book) {
        return this.bookRepository.delete(book);
    }

    @Override
    public int delete(Author fk_author) {
        return this.bookRepository.delete(fk_author);
    }

    @Override
    public int update(Book book) {
        return this.bookRepository.update(book);
    }

    @Override
    public int updatePk_isbn(Book book, String pk_isbn) {
        return this.bookRepository.updatePk_isbn(book, pk_isbn);
    }

    @Override
    public int updateTitle(Book book, String title) {
        return this.bookRepository.updateTitle(book, title);
    }

    @Override
    public int updateAuthor(Book book, Author author) {
        return this.bookRepository.updateAuthor(book, author);
    }
}