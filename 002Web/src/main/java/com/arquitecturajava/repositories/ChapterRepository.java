package com.arquitecturajava.repositories;

import com.arquitecturajava.business.Book;
import com.arquitecturajava.business.Chapter;
import java.util.List;

public interface ChapterRepository {
    
    Chapter select(Chapter chapter);
    
    List<Chapter> select();
    
    List<Chapter> select(Book book);
    
    int insert(Chapter chapter);
    
    int delete(Chapter chapter);
    
    int delete(Book book);
    
    int updateTitle(Chapter chapter, String title);
    
    int updatePages(Chapter chapter, int pages);
    
    int updateBook(Chapter chapter, Book book);
}