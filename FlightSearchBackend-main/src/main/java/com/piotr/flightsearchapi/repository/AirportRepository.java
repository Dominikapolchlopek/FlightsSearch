package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

    @Query(value = "SELECT * FROM airports WHERE IATACode = :IATACode", nativeQuery = true)
    Airport findByIATACode(String IATACode);

    @Query(value = "SELECT * FROM airports WHERE City = :City", nativeQuery = true)
    List<Airport> findByCity(String City);

    @Query(value = "SELECT * FROM airports WHERE Country = :Country", nativeQuery = true)
    List<Airport> findByCountry(String Country);

    @Query(value = "SELECT * FROM airports WHERE name = :name", nativeQuery = true)
    Airport findByName(String name);

}
