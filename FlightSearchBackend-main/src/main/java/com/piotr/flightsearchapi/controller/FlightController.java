package com.piotr.flightsearchapi.controller;

import com.piotr.flightsearchapi.domain.dto.*;
import com.piotr.flightsearchapi.domain.entity.Flight;
import com.piotr.flightsearchapi.mapper.FlightMapper;
import com.piotr.flightsearchapi.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flights")
public class FlightController {

    private final FlightService flightService;
    private final FlightMapper flightMapper;

    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @PostMapping("/departureairport")
    public ResponseEntity<List<FlightDto>> findFlightsByStartingAirport(
            @RequestBody FindFlightsByDepartureAirportRequestDto requestDto
            ){
        List<Flight> flights = flightService.findFlightsByFromAirportCode(flightMapper.fromAirportCodeFromDTO(requestDto));
        List<FlightDto> flightsDtos = flights.stream().map(flightMapper::toDTO).toList();
        return ResponseEntity.ok(flightsDtos);
    }

    @PostMapping("/arrivalairport")
    public ResponseEntity<List<FlightDto>> findFlightsByDestinationAirport(
            @RequestBody FindFlightsByArrivalAirportRequestDto requestDto
    ){
        List<Flight> flights = flightService.findFlightsByToAirportCode(flightMapper.toAirportCodeFromDTO(requestDto));
        List<FlightDto> flightsDtos = flights.stream().map(flightMapper::toDTO).toList();
        return ResponseEntity.ok(flightsDtos);
    }

    @PostMapping("/departuretime")
    public ResponseEntity<List<FlightDto>> findFlightsByDepartureTime(
            @RequestBody FindFlightsByDepartureTimeRequestDto requestDto
    ){
        List<Flight> flights = flightService.findFlightsByDepartureTime(flightMapper.departureTimeFromDTO(requestDto));
        List<FlightDto> flightsDtos = flights.stream().map(flightMapper::toDTO).toList();
        return ResponseEntity.ok(flightsDtos);
    }

    @PostMapping("/flightnumber")
    public ResponseEntity<List<FlightDto>> findFlightsByFlightNumber(
            @RequestBody FindFlightsByFlightNumberRequestDto requestDto
    ){
        List<Flight> flights = flightService.findFlightsByNumber(flightMapper.flightNumberFromDTO(requestDto));
        List<FlightDto> flightsDtos = flights.stream().map(flightMapper::toDTO).toList();
        return ResponseEntity.ok(flightsDtos);
    }

    @PostMapping("/arrivalanddeparture")
    public ResponseEntity<List<FlightDto>> findFlightsByArrivalAndDestination(
            @RequestBody FindFlightsByArrivalAndDestinationRequestDto requestDto
    ){
        List<Flight> flights = flightService.findFlightsByToAirportCodeAndFromAirportCode(flightMapper.arrivalAndDestinationAirportsFromDTO(requestDto));
        List<FlightDto> flightsDtos = flights.stream().map(flightMapper::toDTO).toList();
        return ResponseEntity.ok(flightsDtos);
    }

    @PostMapping("/arrivaldepartureandtime")
    public ResponseEntity<List<FlightDto>> findFlights(
            @RequestBody FindFlightsRequestDto requestDto
    ){
        List<Flight> flights = flightService.findFlights(flightMapper.fromDTO(requestDto));
        List<FlightDto> flightsDtos = flights.stream().map(flightMapper::toDTO).toList();
        return ResponseEntity.ok(flightsDtos);
    }
}
