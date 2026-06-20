package com.piotr.flightsearchapi.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record FindFlightsByArrivalAirportRequestDto(
        @NotBlank(message = "To airport code is required")
        String ToAirportCode
) {
}
