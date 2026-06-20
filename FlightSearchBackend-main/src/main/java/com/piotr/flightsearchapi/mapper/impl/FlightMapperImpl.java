package com.piotr.flightsearchapi.mapper.impl;

import com.piotr.flightsearchapi.domain.FindFlightsByAirportsRequest;
import com.piotr.flightsearchapi.domain.FindFlightsRequest;
import com.piotr.flightsearchapi.domain.dto.*;
import com.piotr.flightsearchapi.domain.entity.Flight;
import com.piotr.flightsearchapi.mapper.FlightMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FlightMapperImpl implements FlightMapper {
    @Override
    public FindFlightsRequest fromDTO(FindFlightsRequestDto dto) {
        return new FindFlightsRequest(
                dto.FromAirportCode(),
                dto.ToAirportCode(),
                dto.DepartureTime()
        );
    }

    @Override
    public String fromAirportCodeFromDTO(FindFlightsByDepartureAirportRequestDto dto) {
        return dto.FromAirportCode();
    }

    @Override
    public String toAirportCodeFromDTO(FindFlightsByArrivalAirportRequestDto dto) {
        return dto.ToAirportCode();
    }

    @Override
    public String flightNumberFromDTO(FindFlightsByFlightNumberRequestDto dto) {
        return dto.FlightNumber();
    }

    @Override
    public LocalDate departureTimeFromDTO(FindFlightsByDepartureTimeRequestDto dto) {
        return dto.DepartureTime();
    }

    @Override
    public FindFlightsByAirportsRequest arrivalAndDestinationAirportsFromDTO(FindFlightsByArrivalAndDestinationRequestDto dto) {
        return new FindFlightsByAirportsRequest(
                dto.FromAirportCode(),
                dto.ToAirportCode()
        );
    }

    @Override
    public FlightDto toDTO(Flight flight) {
        if(flight == null) return null;
        return new FlightDto(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getAirlineId(),
                flight.getFromAirportCode(),
                flight.getToAirportCode(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getStatus(),
                flight.getGate(),
                flight.getTerminal()
        );
    }
}
