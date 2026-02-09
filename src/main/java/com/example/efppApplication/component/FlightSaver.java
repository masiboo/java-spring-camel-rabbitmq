package com.example.efppApplication.component;

import com.example.efppApplication.mapper.FlightPlanMapper;
import com.example.efppApplication.model.FlightPlan;
import com.example.efppApplication.repository.FlightPlanRepository;
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
    public void save(FlightPlan flight) {
        repository.save(mapper.toEntity(flight));
    }
}