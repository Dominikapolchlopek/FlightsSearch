package com.piotr.flightsearchapi.domain.dto;

import com.piotr.flightsearchapi.domain.entity.FlightStatus;

import java.time.LocalDate;

public record FlightDto(
        Integer Id,
        String FlightNumber,
        Integer AirlineId,
        String FromAirportCode,
        String ToAirportCode,
        LocalDate DepartureTime,
        LocalDate ArrivalTime,
        FlightStatus Status,
        String Gate,
        String Terminal
) {
}
