package com.keyrus.r2dbcpoc.dto;

public interface PersonDto {
    String getName();
    AddressDto getAddress();

    interface AddressDto {
        String getCity();
    }
}
