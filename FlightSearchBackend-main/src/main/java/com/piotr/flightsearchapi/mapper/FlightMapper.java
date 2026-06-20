package com.piotr.flightsearchapi.mapper;

import com.piotr.flightsearchapi.domain.FindFlightsByAirportsRequest;
import com.piotr.flightsearchapi.domain.FindFlightsRequest;
import com.piotr.flightsearchapi.domain.dto.*;
import com.piotr.flightsearchapi.domain.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightMapper {

    FindFlightsRequest fromDTO(FindFlightsRequestDto dto);
    String fromAirportCodeFromDTO(FindFlightsByDepartureAirportRequestDto dto);
    String toAirportCodeFromDTO(FindFlightsByArrivalAirportRequestDto dto);
    String flightNumberFromDTO(FindFlightsByFlightNumberRequestDto dto);
    LocalDate departureTimeFromDTO(FindFlightsByDepartureTimeRequestDto dto);
    FindFlightsByAirportsRequest arrivalAndDestinationAirportsFromDTO(FindFlightsByArrivalAndDestinationRequestDto dto);
    FlightDto toDTO(Flight flight);

}
