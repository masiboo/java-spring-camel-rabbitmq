package com.example.efppApplication.repository;

import com.example.efppApplication.model.FlightPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FlightPlanRepository extends JpaRepository<FlightPlanEntity, UUID> {

    Optional<FlightPlanEntity> findByFlightId(String flightId);
}
