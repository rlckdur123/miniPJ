package com.ezen.springplanetrip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.springplanetrip.service.airport.AirportService;
import com.ezen.springplanetrip.vo.AirportVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/airport")
public class AirportController {
	@Autowired
	private AirportService airportService;
	
	@GetMapping("/airportInfo.do")
	public String getAirportListView(Model model) {
		List<AirportVO> airportList = airportService.getAirportList();
		
		model.addAttribute("airportList", airportList);
		
		return "/airport/airportInfo";	
	}
	
	
	@PostMapping(value="/airportInfo.do", produces="application/text; charset=UTF-8")
	@ResponseBody
	public String getAirportInfo(AirportVO airportVO) throws JsonProcessingException {
		AirportVO airportInfo = airportService.getAirportInfo(airportVO);
		
		airportInfo.setSelectedAirportId(airportVO.getAirportId());
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("airportInfo", airportInfo);
		
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(returnMap);
		
		return jsonStr;
	}
}
