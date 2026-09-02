package com.example.clean_arquitecture.Clean.Arquitecture.core.book.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts.BookRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request.BookRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBook {

    private final BookRepository bookRepository;

    public Book execute(String id, BookRequest bookRequest) {
        Book book = this.bookRepository.findBookById(id).orElseThrow(() -> new ResourceNotFoundException("Not found book with Id: " + id));
        BookMapper.updateBook(book, bookRequest);
        return bookRepository.save(book);
    }

}
