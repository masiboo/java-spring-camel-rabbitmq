package com.example.efppApplication.model;


import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "flight_plan",
        indexes = {
                @Index(name = "idx_flight_id", columnList = "flight_id"),
                @Index(name = "idx_dep_arr", columnList = "departure, arrival")
        }
)
public class FlightPlanEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "flight_id", nullable = false, length = 16)
    private String flightId;

    @Column(nullable = false, length = 4)
    private String departure;

    @Column(nullable = false, length = 4)
    private String arrival;

    @Column(name = "scheduled_departure", nullable = false)
    private Instant scheduledDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private Instant scheduledArrival;

    @Column(name = "aircraft_type", length = 8)
    private String aircraftType;

    @Column(name = "received_at", nullable = false, updatable = false)
    private Instant receivedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FlightStatus status;

    /* ---------- JPA lifecycle ---------- */
    @PrePersist
    void onCreate() {
        this.receivedAt = Instant.now();
    }

    /* ---------- getters & setters ---------- */

    public UUID getId() {
        return id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Instant getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(Instant scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public Instant getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(Instant scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Instant getReceivedAt() {
        return receivedAt;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}

