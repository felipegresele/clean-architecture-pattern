package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book")
public class BookEntity {

    @Id
    String id;
    String isbn;
    String title;
    String author;
    String publisher;
    Integer publicationYear;
    String category;

}
