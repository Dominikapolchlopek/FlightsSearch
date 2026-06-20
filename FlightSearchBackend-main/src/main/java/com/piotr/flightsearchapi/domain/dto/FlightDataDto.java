package com.piotr.flightsearchapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightDataDto {

    @JsonProperty("flight_status")
    private String flightStatus;

    private DepartureDto departure;
    private ArrivalDto arrival;

    @JsonProperty("flight")
    private FlightInfoDto flightInfo;

    // Gettery i Settery
    public String getFlightStatus() { return flightStatus; }
    public void setFlightStatus(String flightStatus) { this.flightStatus = flightStatus; }

    public DepartureDto getDeparture() { return departure; }
    public void setDeparture(DepartureDto departure) { this.departure = departure; }

    public ArrivalDto getArrival() { return arrival; }
    public void setArrival(ArrivalDto arrival) { this.arrival = arrival; }

    public FlightInfoDto getFlightInfo() { return flightInfo; }
    public void setFlightInfo(FlightInfoDto flightInfo) { this.flightInfo = flightInfo; }



    public static class DepartureDto {
        private String iata;
        private String scheduled;
        private String gate;
        private String terminal;

        public String getIata() { return iata; }
        public void setIata(String iata) { this.iata = iata; }

        public String getScheduled() { return scheduled; }
        public void setScheduled(String scheduled) { this.scheduled = scheduled; }

        public String getGate() { return gate; }
        public void setGate(String gate) { this.gate = gate; }

        public String getTerminal() { return terminal; }
        public void setTerminal(String terminal) { this.terminal = terminal; }
    }

    public static class ArrivalDto {
        private String iata;
        private String scheduled;

        public String getIata() { return iata; }
        public void setIata(String iata) { this.iata = iata; }

        public String getScheduled() { return scheduled; }
        public void setScheduled(String scheduled) { this.scheduled = scheduled; }
    }

    public static class FlightInfoDto {
        private String iata;

        public String getIata() { return iata; }
        public void setIata(String iata) { this.iata = iata; }
    }
}