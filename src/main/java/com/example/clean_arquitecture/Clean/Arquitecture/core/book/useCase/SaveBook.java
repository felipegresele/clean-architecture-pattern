package com.example.clean_arquitecture.Clean.Arquitecture.core.book.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts.BookRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request.BookRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveBook {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book execute(BookRequest request) {
        Book book = this.bookMapper.toRequestToEntity(request);
        this.bookRepository.save(book);
        return book;
    }

}
