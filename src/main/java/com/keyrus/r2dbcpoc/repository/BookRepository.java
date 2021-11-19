package com.keyrus.r2dbcpoc.repository;

import com.keyrus.r2dbcpoc.model.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface BookRepository extends R2dbcRepository<Book, UUID> {

    @Query("select book.*, author.id as authorId, author.name as authorName "
            + "from Book book join Author author on author.id = book.author ")
    public Flux<Book> findAll();

}
