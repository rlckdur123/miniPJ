package com.ezen.springplanetrip.service.flight.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.flight.FlightService;
import com.ezen.springplanetrip.vo.AirportVO;
import com.ezen.springplanetrip.vo.Criteria;
import com.ezen.springplanetrip.vo.FlightVO;

@Service
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDAO flightDAO;

	@Override
	public List<FlightVO> viewFlight(Map<String, String> flyMap, Criteria cri) {
		return flightDAO.viewFlight(flyMap, cri);
	}

	@Override
	public List<AirportVO> viewAirport(Map<String, String> airportMap) {
		return flightDAO.viewAirport(airportMap);
	}
	
	@Override
	public int getFlightTotalCnt(Map<String, String> flyMap) {
		return flightDAO.getFlightTotalCnt(flyMap);
	}
}
