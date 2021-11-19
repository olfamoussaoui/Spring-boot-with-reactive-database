package com.keyrus.r2dbcpoc.repository;

import com.keyrus.r2dbcpoc.model.Author;
import com.keyrus.r2dbcpoc.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AuthorCustomRepository {
    private final DatabaseClient databaseClient;

    public Flux<Author> findAll() {
        return databaseClient.sql(
                        "SELECT  "
                                + "	book.id as bookId, book.title as bookName, book.date_of_parution as dateOfParution, "
                                + " author.id as authorId, author.name as authorName "
                                + "FROM author "
                                + "JOIN book on author.id = book.author "
                                + "ORDER BY authorId")
                .fetch()
                .all()
                .bufferUntilChanged( result -> result.get("authorId"))
                .map(list -> {
                    Author.AuthorBuilder author = Author.builder();
                    author.name(String.valueOf(list.get(0).get("authorName")));
                    author.id((UUID) list.get(0).get("authorId"));

                    author.books(
                            list.stream()
                                    .map(map -> {
                                        return Book.builder()
                                                .title((String) map.get("bookName"))
                                                .id((UUID) map.get( "bookId"))
                                                .dateOfParution((LocalDate) map.get("dateOfParution"))
                                                .build();
                                    }).collect(Collectors.toList())
                    );
                    return author.build();
                });
    }
}
