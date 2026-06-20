package com.piotr.flightsearchapi;

import org.springframework.boot.SpringApplication;

public class TestFlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.from(FlightSearchApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
