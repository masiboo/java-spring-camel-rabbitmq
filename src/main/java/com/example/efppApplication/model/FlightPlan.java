package com.example.efppApplication.model;

import lombok.Data;

import java.time.Instant;

@Data
public class FlightPlan {
    private String flightId;
    private String departure;
    private String arrival;
    private Instant scheduledDeparture;
    private Instant scheduledArrival;
    private String aircraftType;
}
