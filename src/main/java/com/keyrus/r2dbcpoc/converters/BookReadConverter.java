package com.keyrus.r2dbcpoc.converters;

import com.keyrus.r2dbcpoc.dto.BookDto;
import com.keyrus.r2dbcpoc.model.Author;
import com.keyrus.r2dbcpoc.model.Book;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.LocalDate;
import java.util.UUID;

@ReadingConverter
public class BookReadConverter implements Converter<Row, BookDto> {
    @Override
    public BookDto convert(Row source) {
        Author author = Author.builder()
                .name(source.get("authorName", String.class))
                .id(source.get("authorId", UUID.class))
                .build();
        return BookDto.builder()
                .id(source.get("id", UUID.class))
                .author(author)
                .title(source.get("title", String.class))
                .dateOfParution(source.get("date_of_parution", LocalDate.class))
                .build();

    }
}
