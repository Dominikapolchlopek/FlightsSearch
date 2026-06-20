package com.piotr.flightsearchapi.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "flights", schema = "flightsearch")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String FlightNumber;
    private Integer AirlineId;
    private String FromAirportCode;
    private String ToAirportCode;
    private LocalDate DepartureTime;
    private LocalDate ArrivalTime;
    @Enumerated(EnumType.STRING)
    private FlightStatus Status;
    private String Gate;
    private String Terminal;

    public Flight() {
    }

    public Flight(Integer id, String flightNumber, Integer airlineId, String fromAirportCode, String toAirportCode, LocalDate departureTime, LocalDate arrivalTime, FlightStatus status, String gate, String terminal) {
        Id = id;
        FlightNumber = flightNumber;
        AirlineId = airlineId;
        FromAirportCode = fromAirportCode;
        ToAirportCode = toAirportCode;
        DepartureTime = departureTime;
        ArrivalTime = arrivalTime;
        Status = status;
        Gate = gate;
        Terminal = terminal;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public Integer getAirlineId() {
        return AirlineId;
    }

    public void setAirlineId(Integer airlineId) {
        AirlineId = airlineId;
    }

    public String getFromAirportCode() {
        return FromAirportCode;
    }

    public void setFromAirportCode(String fromAirportCode) {
        FromAirportCode = fromAirportCode;
    }

    public String getToAirportCode() {
        return ToAirportCode;
    }

    public void setToAirportCode(String toAirportCode) {
        ToAirportCode = toAirportCode;
    }

    public LocalDate getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        DepartureTime = departureTime;
    }

    public LocalDate getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public FlightStatus getStatus() {
        return Status;
    }

    public void setStatus(FlightStatus status) {
        Status = status;
    }

    public String getGate() {
        return Gate;
    }

    public void setGate(String gate) {
        Gate = gate;
    }

    public String getTerminal() {
        return Terminal;
    }

    public void setTerminal(String terminal) {
        Terminal = terminal;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "Id=" + Id +
                ", FlightNumber='" + FlightNumber + '\'' +
                ", AirlineId=" + AirlineId +
                ", FromAirportCode='" + FromAirportCode + '\'' +
                ", ToAirportCode='" + ToAirportCode + '\'' +
                ", DepartureTime=" + DepartureTime +
                ", ArrivalTime=" + ArrivalTime +
                ", Status=" + Status +
                ", Gate='" + Gate + '\'' +
                ", Terminal='" + Terminal + '\'' +
                '}';
    }
}
