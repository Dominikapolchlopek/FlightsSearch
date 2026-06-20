package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FindFlightsRequestDto(
        @NotBlank(message = "From airport code is required")
        String FromAirportCode,
        @NotBlank(message = "To airport code is required")
        String ToAirportCode,
        @NotBlank(message = "Departure time is required")
        LocalDate DepartureTime
) {
}
