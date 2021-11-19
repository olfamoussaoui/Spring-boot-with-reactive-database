package com.keyrus.r2dbcpoc.controller;

import com.keyrus.r2dbcpoc.model.Book;
import com.keyrus.r2dbcpoc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public Flux<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public Mono<Book> createNewBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
