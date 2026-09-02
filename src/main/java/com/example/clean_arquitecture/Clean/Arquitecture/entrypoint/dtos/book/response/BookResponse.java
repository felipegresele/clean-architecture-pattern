package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.book.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    String isbn;
    String title;
    String author;
    String publisher;
    Integer publicationYear;
    String category;
}
