package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FindFlightsByDepartureTimeRequestDto(
        @NotBlank(message = "Departure time is required")
        LocalDate DepartureTime
) {
}
