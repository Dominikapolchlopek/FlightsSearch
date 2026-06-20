package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateFavoriteRequestDto(
        @NotBlank(message = "Flight id is required")
        int FlightId
) {

}
