package com.ezen.springplanetrip.service.airport;

import java.util.List;

import com.ezen.springplanetrip.vo.AirportVO;

public interface AirportService {
	
	List<AirportVO> getAirportList();
	
	AirportVO getAirportInfo(AirportVO airportVO);
}
