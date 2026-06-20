package com.piotr.flightsearchapi.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "airlines", schema = "flightsearch")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String IATACode;

    public Airline() {
    }

    public Airline(Integer id, String name, String IATACode) {
        Id = id;
        Name = name;
        this.IATACode = IATACode;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;
        return Objects.equals(Id, airline.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", IATACode='" + IATACode + '\'' +
                '}';
    }
}
