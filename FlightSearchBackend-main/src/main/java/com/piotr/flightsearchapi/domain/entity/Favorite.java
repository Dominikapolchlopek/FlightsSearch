package com.piotr.flightsearchapi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites", schema = "flightsearch")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private int UserId;
    private int FlightId;

    public Favorite() {
    }

    public Favorite(Integer id, int userId, int flightId) {
        Id = id;
        UserId = userId;
        FlightId = flightId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getFlightId() {
        return FlightId;
    }

    public void setFlightId(int flightId) {
        FlightId = flightId;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "Id=" + Id +
                ", UserId=" + UserId +
                ", FlightId=" + FlightId +
                '}';
    }
}
