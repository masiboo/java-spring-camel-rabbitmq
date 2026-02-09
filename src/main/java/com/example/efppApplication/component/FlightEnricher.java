package com.example.efppApplication.component;

import com.example.efppApplication.model.FlightPlan;
import org.springframework.stereotype.Component;

@Component
public class FlightEnricher {

    public FlightPlan enrich(FlightPlan flight) {
        // Simple enrichment logic
        return flight;
    }
}