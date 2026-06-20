package com.piotr.flightsearchapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApplication.class, args);
	}

}
