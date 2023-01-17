package com.ezen.springplanetrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springplanetrip.service.aircraft.AircraftService;

@Controller
@RequestMapping("/aircraft")
public class AircraftController {
	@Autowired
	private AircraftService aircraftService;
	
}
