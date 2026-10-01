package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request.BookRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.response.BookResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(description = "Get all books")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("/save")
    @Operation(description = "Save book")
    @ApiResponse(responseCode = "201", description = "Insert successful")
    public ResponseEntity<BookResponse> save(@RequestBody BookRequest request) {
        return this.bookService.saveBook(request);
    }

    @GetMapping("/get-book")
    @Operation(description = "Find book by name")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<List<BookResponse>> findBookByName(
            @RequestParam(name = "title", required = false) String title) {
        return this.bookService.getBookByName(title);
    }

    @GetMapping("/{id}")
    @Operation(description = "Find book by id")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<BookResponse> findBookById(
            @PathVariable String id) {
        return this.bookService.getBookById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Update book by id")
    @ApiResponse(responseCode = "201", description = "Updated successful")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable String id,
            @RequestBody BookRequest bookRequest) {
        return this.bookService.updateBookById(id, bookRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Delete book by id")
    @ApiResponse(responseCode = "204", description = "Deleted successful, no content")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.bookService.deleteBookById(id);
    }
}
