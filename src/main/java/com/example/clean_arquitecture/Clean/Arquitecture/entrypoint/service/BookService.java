package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.core.book.useCase.*;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request.BookRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.response.BookResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    //Use Case
    private final SaveBook saveBook;
    private final GetListBook getListBook;
    private final GetBookByName getBookByName;
    private final GetBookById getBookById;
    private final DeleteBookById deleteBookById;
    private final UpdateBook updateBook;

    public ResponseEntity<BookResponse> saveBook(BookRequest request) {
        Book book = this.saveBook.execute(request);
        return new ResponseEntity<>(BookMapper.toDomainToResponse(book), HttpStatus.CREATED);
    }

    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<Book> bookList = this.getListBook.execute();
        return new ResponseEntity<>(BookMapper.toListBookResponse(bookList),HttpStatus.OK);
    }

    public ResponseEntity<List<BookResponse>> getBookByName(String title) {
        List<Book> bookList = this.getBookByName.execute(title);
        return new ResponseEntity<>(BookMapper.toListBookResponse(bookList), HttpStatus.OK);
    }

    public ResponseEntity<BookResponse> getBookById(String id) {
        Book book = this.getBookById.execute(id);
        return new ResponseEntity<>(BookMapper.toDomainToResponse(book), HttpStatus.OK);
    }

    public ResponseEntity<BookResponse> updateBookById(String id, BookRequest request) {
        Book book = this.updateBook.execute(id, request);
        return new ResponseEntity<>(BookMapper.toDomainToResponse(book), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteBookById(String id) {
        this.deleteBookById.execute(id);
        return new ResponseEntity<>("Book with Id " + id + " deleted", HttpStatus.OK);
    }
}
