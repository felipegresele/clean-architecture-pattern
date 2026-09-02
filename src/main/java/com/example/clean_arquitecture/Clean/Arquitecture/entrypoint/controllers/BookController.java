package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request.BookRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.response.BookResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("/save")
    public ResponseEntity<BookResponse> save(@RequestBody BookRequest request) {
        return this.bookService.saveBook(request);
    }

    @GetMapping("/get-book")
    public ResponseEntity<List<BookResponse>> findBookByIdOrName(
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "name", required = false) String name) {
        return this.bookService.getBookByIdOrName(id, name);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable String id,
            @RequestBody BookRequest bookRequest) {
        return this.bookService.updateBookById(id, bookRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.bookService.deleteBookById(id);
    }
}
