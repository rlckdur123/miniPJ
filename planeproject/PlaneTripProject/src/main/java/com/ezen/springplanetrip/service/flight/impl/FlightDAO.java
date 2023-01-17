package com.ezen.springplanetrip.service.flight.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.springplanetrip.vo.AirportVO;
import com.ezen.springplanetrip.vo.Criteria;
import com.ezen.springplanetrip.vo.FlightVO;

@Repository
public class FlightDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<FlightVO> viewFlight(Map<String, String> flyMap, Criteria cri) {
		Map<String, Object> flightMap = new HashMap<String, Object>();
		//System.out.println("가져온 맵 : " + flyMap);
		
		flightMap.put("flightMap", flyMap);
		
		cri.setStartNum((cri.getPageNum()-1) * cri.getAmount());
		flightMap.put("cri", cri);
		
		return mybatis.selectList("FlightDAO.viewFlight", flightMap);
	}

	public List<AirportVO> viewAirport(Map<String, String> airportMap) {
		return mybatis.selectList("FlightDAO.viewAirport", airportMap);
	}

	public int getFlightTotalCnt(Map<String, String> flyMap) {
		Map<String, Object> flightMap = new HashMap<String, Object>();
		
		flightMap.put("flightMap", flyMap);
		return mybatis.selectOne("FlightDAO.getFlightTotalCnt", flightMap);
	}
}
