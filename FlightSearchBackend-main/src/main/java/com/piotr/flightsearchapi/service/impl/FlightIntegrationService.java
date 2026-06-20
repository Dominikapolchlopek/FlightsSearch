package com.piotr.flightsearchapi.service.impl;

import com.piotr.flightsearchapi.domain.dto.AviationStackResponseDto;
import com.piotr.flightsearchapi.domain.dto.FlightDataDto;
import com.piotr.flightsearchapi.domain.entity.Flight;
import com.piotr.flightsearchapi.domain.entity.FlightStatus;
import com.piotr.flightsearchapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightIntegrationService {

    private final RestTemplate restTemplate;
    private final FlightRepository flightRepository;

    @Value("${aviationstack.api.url}")
    private String apiUrl;

    @Value("${aviationstack.api.key}")
    private String apiKey;

    public FlightIntegrationService(RestTemplate restTemplate, FlightRepository flightRepository) {
        this.restTemplate = restTemplate;
        this.flightRepository = flightRepository;
    }

    @Transactional
    public void fetchAndSaveFlightsFromApi() {
        String url = apiUrl + "/flights?access_key=" + apiKey;

                AviationStackResponseDto response = restTemplate.getForObject(url, AviationStackResponseDto.class);

        if (response != null && response.getData() != null) {
            List<Flight> flightsToSave = response.getData().stream()
                    .map(this::mapToEntity)
                    .toList();

            flightRepository.saveAll(flightsToSave);
        }
    }


    private Flight mapToEntity(FlightDataDto dto) {
        Flight flight = new Flight();


        if (dto.getFlightInfo() != null) {
            flight.setFlightNumber(dto.getFlightInfo().getIata());
        }


        if (dto.getDeparture() != null) {
            flight.setFromAirportCode(dto.getDeparture().getIata());
            flight.setGate(dto.getDeparture().getGate());
            flight.setTerminal(dto.getDeparture().getTerminal());


            if (dto.getDeparture().getScheduled() != null) {
                String dateString = dto.getDeparture().getScheduled().substring(0, 10);
                flight.setDepartureTime(LocalDate.parse(dateString));
            }
        }


        if (dto.getArrival() != null) {
            flight.setToAirportCode(dto.getArrival().getIata());

            if (dto.getArrival().getScheduled() != null) {
                String dateString = dto.getArrival().getScheduled().substring(0, 10);
                flight.setArrivalTime(LocalDate.parse(dateString));
            }
        }

        if (dto.getFlightStatus() != null) {
            try {
                flight.setStatus(FlightStatus.valueOf(dto.getFlightStatus().toUpperCase()));
            } catch (IllegalArgumentException e) {

            }
        }

        flight.setAirlineId(null);
        return flight;
    }

    @Scheduled(fixedRate = 3600000*24) // Wykonuje się co dzień (w milisekundach)
    public void autoSyncFlights() {
        fetchAndSaveFlightsFromApi();
    }
}
