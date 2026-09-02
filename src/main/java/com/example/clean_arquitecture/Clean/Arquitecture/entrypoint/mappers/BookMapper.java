package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request.BookRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public static BookResponse toEntityToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setAuthor(book.getAuthor());
        response.setTitle(book.getTitle());
        response.setCategory(book.getCategory());
        response.setPublicationYear(book.getPublicationYear());
        response.setPublisher(book.getPublisher());
        response.setIsbn(book.getIsbn());

        return response;
    }

    public Book toRequestToEntity(BookRequest request) {
        Book entity = new Book();
        entity.setAuthor(request.getAuthor());
        entity.setTitle(request.getTitle());
        entity.setCategory(request.getCategory());
        entity.setPublicationYear(request.getPublicationYear());
        entity.setPublisher(request.getPublisher());
        entity.setIsbn(request.getIsbn());

        return entity;
    }

    public static List<BookResponse> toListBookResponse(List<Book> bookList) {
        List<BookResponse> responseList = new ArrayList<>();
        for (Book book : bookList) {
            BookResponse bookResponse = toEntityToResponse(book);
            responseList.add(bookResponse);
        }
        return responseList;
    }

    public static void updateBook(Book entity, BookRequest request) {
        entity.setAuthor(request.getAuthor());
        entity.setTitle(request.getTitle());
        entity.setCategory(request.getCategory());
        entity.setPublicationYear(request.getPublicationYear());
        entity.setPublisher(request.getPublisher());
        entity.setIsbn(request.getIsbn());
    }

}
