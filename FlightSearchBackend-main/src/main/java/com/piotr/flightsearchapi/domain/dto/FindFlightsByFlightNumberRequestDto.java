package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record FindFlightsByFlightNumberRequestDto(
        @NotBlank(message = "Flight Number is required")
        String FlightNumber

) {
}
