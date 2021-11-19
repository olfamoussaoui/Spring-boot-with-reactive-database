package com.keyrus.r2dbcpoc.dto;

import com.keyrus.r2dbcpoc.model.Author;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private UUID id;

    private String title;

    private Author author;

    private LocalDate dateOfParution;
}
