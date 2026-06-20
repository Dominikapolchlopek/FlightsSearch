package com.piotr.flightsearchapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AviationStackResponseDto {
    private List<FlightDataDto> data;


    public List<FlightDataDto> getData() { return data; }
    public void setData(List<FlightDataDto> data) { this.data = data; }
}

