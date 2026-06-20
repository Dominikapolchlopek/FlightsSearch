package com.piotr.flightsearchapi.domain.dto;

public record FavoriteDto(
        Integer Id,
        int UserId,
        int FlightId
) {
}
