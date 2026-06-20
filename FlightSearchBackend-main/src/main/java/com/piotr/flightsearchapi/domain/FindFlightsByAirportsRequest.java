package com.piotr.flightsearchapi.domain;

public record FindFlightsByAirportsRequest(
        String FromAirportCode, String ToAirportCode
) {
}
