package com.example.efppApplication.mapper;


import com.example.efppApplication.model.FlightPlan;
import com.example.efppApplication.model.FlightPlanEntity;
import com.example.efppApplication.model.FlightStatus;
import org.springframework.stereotype.Component;

@Component
public class FlightPlanMapper {

    public FlightPlanEntity toEntity(FlightPlan dto) {
        FlightPlanEntity entity = new FlightPlanEntity();

        entity.setFlightId(dto.getFlightId());
        entity.setDeparture(dto.getDeparture());
        entity.setArrival(dto.getArrival());
        entity.setScheduledDeparture(dto.getScheduledDeparture());
        entity.setScheduledArrival(dto.getScheduledArrival());
        entity.setAircraftType(dto.getAircraftType());
        entity.setStatus(FlightStatus.RECEIVED);

        return entity;
    }
}