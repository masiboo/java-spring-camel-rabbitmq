package com.example.efppApplication.component;

import com.example.efppApplication.dto.FlightPlanDTO;
import com.example.efppApplication.mapper.FlightPlanMapper;
import com.example.efppApplication.model.FlightPlan;
import com.example.efppApplication.repository.FlightPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.springframework.transaction.annotation.Transactional;

@Component
public class FlightSaver {

    private final FlightPlanRepository repository;
    private final FlightPlanMapper mapper;

    public FlightSaver(
            FlightPlanRepository repository,
            FlightPlanMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public void save(FlightPlanDTO flight) {
        repository.save(mapper.toEntity(flight));
    }
}


