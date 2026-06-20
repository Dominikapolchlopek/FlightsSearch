package com.piotr.flightsearchapi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airports", schema = "flightsearch")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String City;
    private String Country;
    private String IATACode;

    public Airport() {
    }

    public Airport(Integer id, String name, String city, String country, String IATACode) {
        Id = id;
        Name = name;
        City = city;
        Country = country;
        this.IATACode = IATACode;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", IATACode='" + IATACode + '\'' +
                '}';
    }
}
