package com.piotr.flightsearchapi.service;

import com.piotr.flightsearchapi.domain.FindFlightsByAirportsRequest;
import com.piotr.flightsearchapi.domain.FindFlightsRequest;
import com.piotr.flightsearchapi.domain.entity.Flight;

import java.time.LocalDate;
import java.util.List;


public interface FlightService {
    List<Flight> getAllFlights();

    Flight addFlight(Flight flight);
    List<Flight> findFlights(FindFlightsRequest request);
    Flight updateFlight(Flight flight);
    void deleteFlight(Integer Id);
    List<Flight> findFlightsByFromAirportCode(String FromAirportCode);
    List<Flight> findFlightsByToAirportCode(String ToAirportCode);
    List<Flight> findFlightsByDepartureTime(LocalDate DepartureTime);
    List<Flight> findFlightsByNumber(String FlightNumber);
    List<Flight> findFlightsByToAirportCodeAndFromAirportCode(FindFlightsByAirportsRequest request);

}
