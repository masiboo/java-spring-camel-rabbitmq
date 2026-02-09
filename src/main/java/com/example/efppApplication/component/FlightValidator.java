package com.example.efppApplication.component;

import com.example.efppApplication.model.FlightPlan;
import org.springframework.stereotype.Component;

@Component
public class FlightValidator {

    public FlightPlan validate(FlightPlan flight) {
        if (flight.getFlightId() == null) {
            throw new IllegalArgumentException("Flight ID is missing");
        }
        return flight;
    }
}