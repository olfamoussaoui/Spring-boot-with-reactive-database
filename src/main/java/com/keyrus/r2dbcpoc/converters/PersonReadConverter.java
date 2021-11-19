package com.keyrus.r2dbcpoc.converters;

import com.keyrus.r2dbcpoc.model.Person;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.UUID;

@ReadingConverter
public class PersonReadConverter implements Converter<Row, Person> {

    @Override
    public Person convert(Row source) {
        Person.Address address = Person.Address.builder()
                .city(source.get("city", String.class))
                .zipCode(source.get("zip_code", String.class))
                .street(source.get("street", String.class))
                .build();

        return Person.builder()
                .address(address)
                .name(source.get("name", String.class))
                .id(source.get("id", UUID.class))
                .build();
    }

}
