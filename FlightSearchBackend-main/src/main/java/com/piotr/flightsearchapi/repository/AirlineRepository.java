package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    @Query(value = "SELECT * FROM airlines WHERE IATACode = :IATACode", nativeQuery = true)
    Airline findByIATACode(String IATACode);

    @Query(value = "SELECT * FROM airlines WHERE name = :name", nativeQuery = true)
    Airline findByName(String name);
}
