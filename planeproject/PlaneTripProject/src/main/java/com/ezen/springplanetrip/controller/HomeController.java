package com.ezen.springplanetrip.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springplanetrip.service.flight.FlightService;
import com.ezen.springplanetrip.vo.AirportVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private FlightService flightService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<AirportVO> airportList = flightService.viewAirport(null);
		
		model.addAttribute("airportList", airportList);
		
		return "../../mainPage";
	}
	
	//로그인 성공하고 다시 돌아오는 페이지
	@RequestMapping("/mainPage.do")
	public String home(Model model) {
		System.out.println("공항정보를 불러내는 중입니다.");
		List<AirportVO> airportList = flightService.viewAirport(null);
		System.out.println(airportList);
		
		model.addAttribute("airportList", airportList);
		
		return "../../mainPage";
	}
	
}
