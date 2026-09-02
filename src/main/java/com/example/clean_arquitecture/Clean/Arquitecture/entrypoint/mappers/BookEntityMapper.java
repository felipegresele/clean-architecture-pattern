package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.BookEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookEntityMapper {

    public static BookEntity domainToEntity(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setCategory(book.getCategory());
        bookEntity.setPublicationYear(book.getPublicationYear());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setIsbn(book.getIsbn());

        return bookEntity;
    }

    public static Book entityToDomain(BookEntity bookEntity) {
        Book book = new Book();
        book.setAuthor(bookEntity.getAuthor());
        book.setTitle(bookEntity.getTitle());
        book.setCategory(bookEntity.getCategory());
        book.setPublicationYear(bookEntity.getPublicationYear());
        book.setPublisher(bookEntity.getPublisher());
        book.setIsbn(bookEntity.getIsbn());

        return book;
    }

    public static List<Book> listBookDomain(List<BookEntity> list) {
        List<Book> listDomain = new ArrayList<>();
        for (BookEntity bookEntity : list) {
            listDomain.add(entityToDomain(bookEntity));
        }
        return listDomain;
    }
}
