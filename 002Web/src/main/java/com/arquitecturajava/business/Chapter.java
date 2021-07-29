package com.arquitecturajava.business;

import java.util.Objects;

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
    
    public Chapter(String title, Book book) {
        this.pk_title = title;
        this.fk_book = book;
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
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.pk_title);
        hash = 31 * hash + Objects.hashCode(this.fk_book);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chapter other = (Chapter) obj;
        if (!Objects.equals(this.pk_title, other.pk_title)) {
            return false;
        }
        if (!Objects.equals(this.fk_book, other.fk_book)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.fk_book.getTitle() + "] Capítulo: " + this.pk_title + " [" + this.pages + " pags]";
    }
}