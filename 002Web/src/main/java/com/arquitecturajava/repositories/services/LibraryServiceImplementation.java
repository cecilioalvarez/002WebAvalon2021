package com.arquitecturajava.repositories.services;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.business.Chapter;
import com.arquitecturajava.repositories.AuthorRepository;
import com.arquitecturajava.repositories.BookRepository;
import com.arquitecturajava.repositories.ChapterRepository;
import java.util.List;

public class LibraryServiceImplementation implements LibraryService {

    private BookRepository bookRepository;
    private ChapterRepository chapterRepository;
    private AuthorRepository authorRepository;

    public LibraryServiceImplementation(BookRepository bookRepository, ChapterRepository chapterRepository, 
            AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.chapterRepository = chapterRepository;
        this.authorRepository = authorRepository;
    }
    
    public LibraryServiceImplementation(BookRepository repository) {
        this.bookRepository = repository;
    }
    
    public LibraryServiceImplementation(ChapterRepository repository) {
        this.chapterRepository = repository;
    }

    public LibraryServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void setBookRepository(BookRepository repository) {
        this.bookRepository = repository;
    }

    public void setChapterRepository(ChapterRepository repository) {
        this.chapterRepository = repository;
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
    public List<Book> selectBooks(Author fk_author) {
        return this.bookRepository.select(fk_author);
    }

    @Override
    public int insert(Book book) {
        return this.bookRepository.insert(book);
    }

    @Override
    public int deleteBook(Book book) {
        return this.bookRepository.delete(book);
    }

    @Override
    public int deleteBooks(Author fk_author) {
        return this.bookRepository.deleteBooks(fk_author);
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

    @Override
    public Chapter select(Chapter chapter) {
        return this.chapterRepository.select(chapter);
    }

    @Override
    public List<Chapter> select() {
        return this.chapterRepository.select();
    }

    @Override
    public List<Chapter> select(Book book) {
        return this.chapterRepository.select(book);
    }

    @Override
    public int insert(Chapter chapter) {
        return this.chapterRepository.insert(chapter);
    }

    @Override
    public int delete(Chapter chapter) {
        return this.chapterRepository.delete(chapter);
    }

    @Override
    public int deleteChapters(Book book) {
        return this.chapterRepository.delete(book);
    }

    @Override
    public int update(Chapter chapter) {
        return this.chapterRepository.update(chapter);
    }

    @Override
    public int updateTitle(Chapter chapter, String title) {
        return this.chapterRepository.updateTitle(chapter, title);
    }

    @Override
    public int updatePages(Chapter chapter, int pages) {
        return this.chapterRepository.updatePages(chapter, pages);
    }

    @Override
    public int updateBook(Chapter chapter, Book book) {
        return this.chapterRepository.updateBook(chapter, book);
    }

    @Override
    public Author select(Author author) {
        return this.authorRepository.select(author);
    }

    @Override
    public List<Author> selectAuthors() {
       return this.authorRepository.select();
    }

    @Override
    public int insert(Author author) {
        return this.authorRepository.insert(author);
    }

    @Override
    public int delete(Author author) {
        return this.authorRepository.delete(author);
    }

    @Override
    public int update(Author author) {
        return this.authorRepository.update(author);
    }

    @Override
    public int updatePk_id(Author author, String pk_id) {
        return this.authorRepository.updatePk_id(author, pk_id);
    }

    @Override
    public int updateName(Author author, String name) {
        return this.authorRepository.updateName(author, name);
    }

    @Override
    public int updateAge(Author author, int age) {
        return this.authorRepository.updateAge(author, age);
    }
}