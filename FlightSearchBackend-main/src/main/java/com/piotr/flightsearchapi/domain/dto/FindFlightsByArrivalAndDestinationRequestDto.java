package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record FindFlightsByArrivalAndDestinationRequestDto(
        @NotBlank(message = "From airport code is required")
        String FromAirportCode,
        @NotBlank(message = "To airport code is required")
        String ToAirportCode
) {
}
