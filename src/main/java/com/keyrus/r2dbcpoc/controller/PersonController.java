package com.keyrus.r2dbcpoc.controller;

import com.keyrus.r2dbcpoc.dto.PersonDto;
import com.keyrus.r2dbcpoc.model.Person;
import com.keyrus.r2dbcpoc.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/summary")
    public Flux<PersonDto> findAllSummary() {
        return personRepository.findAllPersons();
    }

    @PostMapping
    public Mono<Person> createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
