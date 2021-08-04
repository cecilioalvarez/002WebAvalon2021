package com.arquitecturajava.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;


public class Chapter {

    private String pk_title;
    private int pages;
    @JsonIgnore
    private Book pk_fk_book;

    public Chapter(String title, int pages, Book book) {
        this.pk_title = title;
        this.pages = pages;
        this.pk_fk_book = book;
    }
    
    public Chapter(String title, Book book) {
        this.pk_title = title;
        this.pk_fk_book = book;
    }

    public String getPk_title() {
        return this.pk_title;
    }

    public int getPages() {
        return this.pages;
    }

    public Book getPk_fk_book() {
        return this.pk_fk_book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.pk_title);
        hash = 31 * hash + Objects.hashCode(this.pk_fk_book);
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
        if (!Objects.equals(this.pk_fk_book, other.pk_fk_book)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.pk_fk_book.getTitle() + "] Capítulo: " + this.pk_title + " [" + this.pages + " pags]";
    }
}