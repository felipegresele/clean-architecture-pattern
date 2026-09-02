package com.example.clean_arquitecture.Clean.Arquitecture.core.book.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts.BookRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetListBook {

    private final BookRepository bookRepository;

    public List<Book> execute() {
        return this.bookRepository.getAllBooks();
    }
}
