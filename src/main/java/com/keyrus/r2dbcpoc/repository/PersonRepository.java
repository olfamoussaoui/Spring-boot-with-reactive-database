package com.keyrus.r2dbcpoc.repository;

import com.keyrus.r2dbcpoc.dto.PersonDto;
import com.keyrus.r2dbcpoc.model.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, UUID> {
    @Query("select * from Person")
    Flux<PersonDto> findAllPersons();
}
