package com.keyrus.r2dbcpoc.dto;

import java.util.List;
import java.util.UUID;

public interface AuthorDto {
    UUID getId();

    String getName();

    List<BookDto> getBooks();
}
