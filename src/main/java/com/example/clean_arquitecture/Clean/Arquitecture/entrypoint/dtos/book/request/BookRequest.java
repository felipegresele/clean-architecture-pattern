package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    String isbn;
    String title;
    String author;
    String publisher;
    Integer publicationYear;
    String category;
}
