package com.keyrus.r2dbcpoc.repository;

import com.keyrus.r2dbcpoc.model.Author;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends R2dbcRepository<Author, UUID> {

}
