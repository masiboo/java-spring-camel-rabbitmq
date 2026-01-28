package com.example.efppApplication.controller;

import com.example.efppApplication.dto.FlightPlanDTO;
import com.example.efppApplication.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public ResponseEntity<String> submitFlight(@RequestBody FlightPlanDTO flight) {
        producerService.publishFlight(flight);
        return ResponseEntity.accepted().body("Flight received");
    }
}

