package com.chubb.FlightBookingSystem.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubb.FlightBookingSystem.dto.FlightSearchRequestDTO;
import com.chubb.FlightBookingSystem.dto.ScheduleRequestDTO;
import com.chubb.FlightBookingSystem.dto.ScheduleResponseDTO;
import com.chubb.FlightBookingSystem.exceptions.FlightNotFoundException;
import com.chubb.FlightBookingSystem.exceptions.ScheduleAlreadyExistsException;
import com.chubb.FlightBookingSystem.model.Flight;
import com.chubb.FlightBookingSystem.model.Schedule;
import com.chubb.FlightBookingSystem.repository.FlightRepository;
import com.chubb.FlightBookingSystem.repository.ScheduleRepository;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	public Mono<Integer> addSchedule(ScheduleRequestDTO scheduleDto) {
        return Mono.fromCallable(() -> {
        	String flightNumber = scheduleDto.getFlightNumber();
		
			Flight flight = flightRepository.findById(flightNumber)
			        .orElseThrow(() -> new FlightNotFoundException(flightNumber));
			
			Schedule schedule = new Schedule(scheduleDto,flight);
			
			if(scheduleRepository.existsByFlight(schedule.getFlight()) &&
					scheduleRepository.existsByDepartureDate(schedule.getDepartureDate())) {
				throw new ScheduleAlreadyExistsException(schedule.getFlight(), schedule.getDepartureDate());
			}
			scheduleRepository.save(schedule);
			return schedule.getId();
		}).subscribeOn(Schedulers.boundedElastic());
	}
}
