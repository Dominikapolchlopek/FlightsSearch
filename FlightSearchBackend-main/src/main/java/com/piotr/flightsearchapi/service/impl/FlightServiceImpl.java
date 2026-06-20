package com.piotr.flightsearchapi.service.impl;

import com.piotr.flightsearchapi.domain.FindFlightsByAirportsRequest;
import com.piotr.flightsearchapi.domain.FindFlightsRequest;
import com.piotr.flightsearchapi.domain.entity.Flight;
import com.piotr.flightsearchapi.repository.FlightRepository;
import com.piotr.flightsearchapi.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> findFlightsByNumber(String FlightNumber) {
        return  flightRepository.findByFlightNumber(FlightNumber);
    }

    @Override
    public Flight addFlight(Flight flight) {
        List<Flight> newFlight = flightRepository.findByFlightNumber(flight.getFlightNumber());
        if(!newFlight.isEmpty()){
            throw new IllegalArgumentException("Flight with this number already exists");
        }
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findFlights(FindFlightsRequest request) {
        return flightRepository.findByToAirportCodeAndFromAirportCodeAndDepartureTime(
                request.ToAirportCode(), request.FromAirportCode(), request.DepartureTime()
        );
    }

    @Override
    public Flight updateFlight(Flight flight) {
        List<Flight> oldFlight = flightRepository.findByFlightNumber(flight.getFlightNumber());
        if(oldFlight.isEmpty()){
            throw new IllegalArgumentException("Flight with this number doesn't exist");
        }
        Flight outdatedFlight = oldFlight.get(0);
        outdatedFlight.setArrivalTime(flight.getArrivalTime());
        outdatedFlight.setDepartureTime(flight.getDepartureTime());
        outdatedFlight.setFromAirportCode(flight.getFromAirportCode());
        outdatedFlight.setToAirportCode(flight.getToAirportCode());
        outdatedFlight.setStatus(flight.getStatus());
        outdatedFlight.setGate(flight.getGate());
        outdatedFlight.setTerminal(flight.getTerminal());
        return flightRepository.save(outdatedFlight);
    }

    @Override
    public void deleteFlight(Integer Id) {
        flightRepository.deleteById(Id);
    }

    @Override
    public List<Flight> findFlightsByFromAirportCode(String FromAirportCode) {
        return flightRepository.findByFromAirportCode(FromAirportCode);
    }

    @Override
    public List<Flight> findFlightsByToAirportCode(String ToAirportCode) {
        return flightRepository.findByToAirportCode(ToAirportCode);
    }

    @Override
    public List<Flight> findFlightsByDepartureTime(LocalDate DepartureTime) {
        return flightRepository.findByDepartureTime(DepartureTime);
    }

    @Override
    public List<Flight> findFlightsByToAirportCodeAndFromAirportCode(FindFlightsByAirportsRequest request) {
        return flightRepository.findByToAirportCodeAndFromAirportCode(
                request.ToAirportCode(), request.FromAirportCode()
        );
    }
}
