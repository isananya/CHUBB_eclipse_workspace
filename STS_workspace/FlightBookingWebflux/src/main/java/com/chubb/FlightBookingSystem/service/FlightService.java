package com.chubb.FlightBookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubb.FlightBookingSystem.exceptions.FlightAlreadyExistsException;
import com.chubb.FlightBookingSystem.model.Flight;
import com.chubb.FlightBookingSystem.repository.FlightRepository;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Mono<String> addFlight(Flight flight) {
        return Mono.fromCallable(() -> {
            if (flightRepository.existsByFlightNumber(flight.getFlightNumber())) {
                throw new FlightAlreadyExistsException(flight.getFlightNumber());
            }
            flightRepository.save(flight);
            return flight.getFlightNumber();
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
