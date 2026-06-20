package com.piotr.flightsearchapi.domain.dto;

public record UserDto(
        Integer Id,
        String Email,
        String PasswordHash
) {
}
