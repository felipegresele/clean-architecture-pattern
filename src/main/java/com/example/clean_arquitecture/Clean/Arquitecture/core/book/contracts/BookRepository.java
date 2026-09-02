package com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> getBookById(String id);

    List<Book> getBookByTitle(String title);

    Optional<Book> findBookById(String id);

    List<Book> getAllBooks();

    void delete(String id);
}
