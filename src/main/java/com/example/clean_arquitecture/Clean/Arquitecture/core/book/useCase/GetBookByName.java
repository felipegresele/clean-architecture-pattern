package com.example.clean_arquitecture.Clean.Arquitecture.core.book.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts.BookRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetBookByName {

    private final BookRepository bookRepository;

    public List<Book> execute(String title) {
        List<Book> bookList = this.bookRepository.getBookByTitle(title);
        if (bookList.isEmpty()) throw new ResourceNotFoundException("Not found book with title " + title);
        return bookList;
    }
}
