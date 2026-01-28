package com.example.efppApplication.service;

import com.example.efppApplication.dto.FlightPlanDTO;
import com.example.efppApplication.model.FlightPlan;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void publishFlight(FlightPlanDTO flight) {
        amqpTemplate.convertAndSend("flight.process", "", flight);
    }
}

