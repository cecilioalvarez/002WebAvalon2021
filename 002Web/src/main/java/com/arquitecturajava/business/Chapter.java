package com.arquitecturajava.business;

public class Chapter {

    private String pk_title;
    private int pages;
    private Book fk_book;

    public Chapter(String title, int pages, Book fk_book) {
        this.pk_title = title;
        this.pages = pages;
        this.fk_book = fk_book;
    }
    
    public Chapter(String title, int pages) {
        this.pk_title = title;
        this.pages = pages;
    }

    public String getPk_title() {
        return this.pk_title;
    }

    public int getPages() {
        return this.pages;
    }

    public Book getFk_book() {
        return this.fk_book;
    }

    @Override
    public String toString() {
        return "[" + this.fk_book.getTitle() + "] Capítulo: " + this.pk_title + " [" + this.pages + " pags]";
    }
}