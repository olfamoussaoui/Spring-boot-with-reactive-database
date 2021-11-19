package com.keyrus.r2dbcpoc.controller;

import com.keyrus.r2dbcpoc.model.Author;
import com.keyrus.r2dbcpoc.repository.AuthorCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorCustomRepository authorRepository;

    @GetMapping
    public Flux<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

}