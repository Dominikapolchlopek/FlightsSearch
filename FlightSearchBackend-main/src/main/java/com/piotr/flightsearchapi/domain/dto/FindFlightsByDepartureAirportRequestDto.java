package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record FindFlightsByDepartureAirportRequestDto(
        @NotBlank(message = "From airport code is required")
        String FromAirportCode
) {
}
