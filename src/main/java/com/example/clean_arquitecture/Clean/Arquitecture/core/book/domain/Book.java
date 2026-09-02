package com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    String isbn;
    String title;
    String author;
    String publisher;
    Integer publicationYear;
    String category;

    public Book() {}

    public Book(String isbn, String title, String author, String publisher, Integer publicationYear, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
    }
}
