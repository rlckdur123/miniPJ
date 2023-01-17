package com.ezen.springplanetrip.service.aircraft.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.aircraft.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService{
	@Autowired
	private AircraftDAO aircraftDAO;
	
}
