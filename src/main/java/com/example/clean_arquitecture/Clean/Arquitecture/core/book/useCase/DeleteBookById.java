package com.example.clean_arquitecture.Clean.Arquitecture.core.book.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBookById {

    private final BookRepository bookRepository;

    public void execute(String id) {
        this.bookRepository.delete(id);
    }

}
