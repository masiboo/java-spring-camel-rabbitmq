package com.example.efppApplication.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class FlightPlanDTO {
    private String flightId;
    private String departure;
    private String arrival;
    private Instant scheduledDeparture;
    private Instant scheduledArrival;
    private String aircraftType;
}