package com.ezen.springplanetrip.service.airport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.airport.AirportService;
import com.ezen.springplanetrip.vo.AirportVO;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private AirportDAO airportDAO; 
	
	@Override
	public List<AirportVO> getAirportList(){
		
		return airportDAO.getAirportList();
	}
	 
	@Override
	public AirportVO getAirportInfo(AirportVO airportVO) {
		return airportDAO.getAirportInfo(airportVO);
	}
}
