package com.arquitecturajava.repositories;

import com.arquitecturajava.business.Chapter;
import java.util.List;

public interface ChapterRepository {
    
    Chapter select(Chapter chapter);
    
    List<Chapter> select();
    
    List<Chapter> select(String fk_book);
    
    int insert(Chapter chapter);
    
    int delete(Chapter chapter);
    
    int delete(String fk_isbn);
    
    int update(Chapter chapter);
    
    int updateTitle(Chapter chapter, String title);
    
    int updatePages(Chapter chapter, int pages);
    
    int updateBook(Chapter chapter, String fk_isbn);
}