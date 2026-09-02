package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.book;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDaoRepository extends MongoRepository<BookEntity, String> {
}
