package com.piotr.flightsearchapi.domain;

import java.time.LocalDate;

public record FindFlightsRequest(
        String FromAirportCode, String ToAirportCode, LocalDate DepartureTime
) {
}
