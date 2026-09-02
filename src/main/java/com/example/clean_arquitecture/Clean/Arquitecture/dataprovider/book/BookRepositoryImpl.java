package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.book;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.contracts.BookRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.BookEntityMapper;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.BookEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    public static final String BOOK_COLLECTION_NAME = "Book";

    private final BookDaoRepository dao;
    private final MongoTemplate mongoTemplate;

    public BookRepositoryImpl(BookDaoRepository dao, MongoTemplate mongoTemplate) {
        this.dao = dao;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = BookEntityMapper.domainToEntity(book);
        this.dao.save(bookEntity);
        return BookEntityMapper.entityToDomain(bookEntity);
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return this.dao.findById(id).map(BookEntityMapper::entityToDomain);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
       Query query = new Query();
       List<Criteria> criterias = new ArrayList<>();

       if (title != null && !title.isEmpty()) {
           criterias.add(Criteria.where("title").regex(title, "i"));
       }

       query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[0])));
       List<BookEntity> list = this.mongoTemplate.find(query, BookEntity.class, BOOK_COLLECTION_NAME);
       return BookEntityMapper.listBookDomain(list);
    }

    @Override
    public Optional<Book> findBookById(String id) {
        return this.dao.findById(id).map(BookEntityMapper::entityToDomain);
    }

    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntityList = this.dao.findAll();
        return BookEntityMapper.listBookDomain(bookEntityList);
    }

    @Override
    public void delete(String id) {
        Optional<BookEntity> bookEntity = this.dao.findById(id);
        if (bookEntity.isPresent()) {
            this.dao.delete(bookEntity.get());
        }
    }
}
