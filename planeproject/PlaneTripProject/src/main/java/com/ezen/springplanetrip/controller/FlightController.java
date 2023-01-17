package com.ezen.springplanetrip.controller;


import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springplanetrip.common.DateToString;
import com.ezen.springplanetrip.common.SwapDptArv;
import com.ezen.springplanetrip.service.flight.FlightService;
import com.ezen.springplanetrip.service.passenger.PassengerService;
import com.ezen.springplanetrip.service.seat.SeatService;
import com.ezen.springplanetrip.vo.AirportVO;
import com.ezen.springplanetrip.vo.Criteria;
import com.ezen.springplanetrip.vo.FlightVO;
import com.ezen.springplanetrip.vo.PageVO;
import com.ezen.springplanetrip.vo.PassengerVO;
import com.ezen.springplanetrip.vo.SeatVO;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private SeatService seatService;
	
	
	@PostMapping("/searchDepartFlight.do")
	public String viewDepartFlight(Model model, @RequestParam Map<String, String> flyMap, Criteria cri) {
		//검색하려는 비행편 정보를 담을 인스턴스
		System.out.println("출발편으로 넘기는 paramMap: " + flyMap);
		
		cri.setAmount(8);	//페이지당 8개만 표시
		//넘어온 값들은 정수가 아닌 문자열
		//flyMap.put("flightId", Integer.parseInt((String)flyMap.get("flightId")));	//flighId값은 정수형이므로 정수형으로 바꿔서
		List<FlightVO> flightList = flightService.viewFlight(flyMap, cri);
		System.out.println(" 메소드 확인 용 디버깅중" + flightList);
		//불러온 flight 출발,도착시간을 문자열 형태로 바꾸고 배열에 저장함. //배열이 아무 것도 없으면 예외 처리를 해야함.
		List<String> startDateList = new ArrayList<String>();
		List<String> arrivalDateList = new ArrayList<String>();;
		if(flightList.size() > 0) {	//검색이 되지않을때의 예외처리
			startDateList = DateToString.changeStringDepartTime(flightList);
			arrivalDateList = DateToString.changeStringArrivalTime(flightList);
			System.out.println("검색이 성공함.");
		}  else {
			List<AirportVO> airportList = flightService.viewAirport(null);
			model.addAttribute("airportList", airportList);
			return "redirect:/mainPage.do";
		}
		
		model.addAttribute("startDateList", startDateList);
		model.addAttribute("arrivalDateList", arrivalDateList);
		
		model.addAttribute("flightInfo", flyMap);
		
		model.addAttribute("flightList", flightList);
		
		//달력에 적은 시작일과 끝 날짜를 저장하는 map
		Map<String, String> calendar = new HashMap<String, String>();
		calendar.put("minimumDate", flyMap.get("minimumDate"));
		calendar.put("maximumDate", flyMap.get("maximumDate"));
		model.addAttribute("calendar", calendar);
		
		//공항 목록 다시 불러오기
		List<AirportVO> airportList = flightService.viewAirport(null);
		model.addAttribute("airportList", airportList);

		
		Map<String, Object> flightSeatList = new HashMap<String, Object>();	//각 비행편의 정보를 모두 담은 객체
		List<List<Integer>> classList = new ArrayList<List<Integer>>(); //각 비행편의 클래스 목록을 담을 배열
		List<List<Integer>> priceList = new ArrayList<List<Integer>>();	//각 비행편의 가격 목록을 담을 배열 비행편마다 가격이 다를것
		List<List<Integer>> remainSeat = new ArrayList<List<Integer>>(); //각 비행편의 남은 자리 목록을 표시할 배열
		flightSeatList.put("flightList", flightList);
		//비행편 들의 좌석 클래스를 표시하는 부분 - Map의 키값은 String, 값은 List<Integer>
		List<Integer> seatClass;
		List<Integer> priceClass;
		List<Integer> seatPot;
		for(int i=0; i < flightList.size(); i++) {
			//각 비행편의 자리 클래스를 가져오는 부분 : 비행편들은 자리의 이름이 있다. 2차원 배열
			seatClass = seatService.viewSeatClass(flightList.get(i).getFlightId());

			classList.add(seatClass);
			
			//좌석들의 가격을 표시하는 구현 - 작업후 나온 결과를 웹페이지로 정보 전달, 2차원 배열
			//가격 정보는 클래스한개씩 검사해서 결과를 가져옴.
			priceClass = seatService.viewSeatPrice(flightList.get(i).getFlightId());

			priceList.add(priceClass);
			//남은 좌석을 가져오기위한 데이터 입력을 하는 작업, 2차원 배열
			seatPot = new ArrayList<Integer>();
			for(int j = 0; j < seatClass.size(); j++) {
				int seatId = classList.get(i).get(j);
				int seatList = seatService.viewSeatRemain(flightList.get(i).getFlightId(), seatId);
				seatPot.add(seatList);
			}
			remainSeat.add(seatPot);
		}
		flightSeatList.put("classList", classList);
		flightSeatList.put("priceList", priceList);
		flightSeatList.put("remainSeat", remainSeat);
		
		model.addAttribute("flightSeatList", flightSeatList);
		//페이지 계산
		int total = flightService.getFlightTotalCnt(flyMap);
		//System.out.println("총 개수 : " + total);
		model.addAttribute("pageVO", new PageVO(cri, total));
		//System.out.println("flightID = " + flightList.get(0).getFlightId());
		
		return "../flight/searchFlight";
	}

	@PostMapping("/searchArriveFlight.do")
	public String viewArriveFlight(Model model, @RequestParam Map<String, String> departFlyMap, Criteria cri) {
		Map<String, String> arriveFlyMap = new HashMap<>();
		//예약하려는 출발 비행편 정보를 담을 인스턴스 복제해서 다음에 진행할 탑승정보 정보를 전달
		Map<String, String> departmentMap = new HashMap<String, String>();
		departmentMap.putAll(departFlyMap);
		model.addAttribute("flightListDpt", departmentMap);
		
		System.out.println("도착편 작업  시작" + departFlyMap);
		//Map<String, String> arriveFlyMap
		//출발 도착지 받은 것을 서로 값을 바꾼뒤 쿼리를 다시수행함.
		String departPoint = departFlyMap.get("departPointId");
		String arrivalPoint = departFlyMap.get("arrivedPointId");
		List<String> changedPoint = SwapDptArv.changeValue(departPoint, arrivalPoint);
		//System.out.println("출 : " + changedPoint.get(0) + " 도 : " + changedPoint.get(1));
		List<String> changedPointCode = SwapDptArv.changeValue(departFlyMap.get("departPointCode"), departFlyMap.get("arrivedPointCode"));
		
		//출발 도착지 아이디, 코드
		departFlyMap.put("departPointId", changedPoint.get(0));
		departFlyMap.put("arrivedPointId", changedPoint.get(1));
		departFlyMap.put("departPointCode", changedPointCode.get(0));
		departFlyMap.put("arrivedPointCode", changedPointCode.get(1));
		cri.setAmount(8);	//페이지당 8개만 표시
		
		System.out.println("스위칭 작업후 출발지의 데이터 : " + departmentMap);
		System.out.println("스위칭 작업후 도착지의 데이터 : " + departFlyMap);
		model.addAttribute("departFlyMap", departFlyMap);
		//넘어온 값들은 정수가 아닌 문자열
		List<FlightVO> flightList = flightService.viewFlight(departFlyMap, cri);
		
		List<String> startDateList = new ArrayList<String>();
		List<String> arrivalDateList = new ArrayList<String>();
		if(flightList.size() > 0) {
			//불러온 flight 출발,도착시간을 문자열 형태로 바꾸고 배열에 저장함.
			startDateList = DateToString.changeStringDepartTime(flightList);
			arrivalDateList = DateToString.changeStringArrivalTime(flightList);
			
			System.out.println("바뀐 출발 하는 곳 : " + flightList.get(0).getAirportDpt());
			System.out.println("바뀐 도착 하는 곳 : " + flightList.get(0).getAirportArv());

		} else {
			System.out.println("해당 항공편은 존재하지 않습니다. 처음부터 다시 항공편을 검색하세요.");
			List<AirportVO> airportList = flightService.viewAirport(null);
			model.addAttribute("airportList", airportList);
			return "redirect:/mainPage.do";
		}

		
		model.addAttribute("startDateList", startDateList);
		model.addAttribute("arrivalDateList", arrivalDateList);
		model.addAttribute("flightListArv", flightList);
		
		System.out.println("flightListArv: " + flightList);
		
		
		//달력에 적은 시작일과 끝 날짜를 저장하는 map
		Map<String, String> calendar = new HashMap<String, String>();
		calendar.put("minimumDate", departFlyMap.get("minimumDate"));
		calendar.put("maximumDate", departFlyMap.get("maximumDate"));
		model.addAttribute("calendar", calendar);
		
		System.out.println("calendar: " + calendar);
		
		//공항 목록 다시 불러오기
		List<AirportVO> airportList = flightService.viewAirport(null);
		model.addAttribute("airportList", airportList);
		
		System.out.println();

		Map<String, Object> flightSeatList = new HashMap<String, Object>();	//각 비행편의 정보를 모두 담은 객체
		List<List<Integer>> classList = new ArrayList<List<Integer>>(); //각 비행편의 클래스 목록을 담을 배열
		List<List<Integer>> priceList = new ArrayList<List<Integer>>();	//각 비행편의 가격 목록을 담을 배열 비행편마다 가격이 다를것
		List<List<Integer>> remainSeat = new ArrayList<List<Integer>>(); //각 비행편의 남은 자리 목록을 표시할 배열
		flightSeatList.put("flightList", flightList);
		//비행편 들의 좌석 클래스를 표시하는 부분 - Map의 키값은 String, 값은 List<Integer>
		List<Integer> seatClass;
		List<Integer> priceClass;
		List<Integer> seatPot;
		for(int i=0; i < flightList.size(); i++) {
			//각 비행편의 자리 클래스를 가져오는 부분 : 비행편들은 자리의 이름이 있다. 2차원 배열
			seatClass = seatService.viewSeatClass(flightList.get(i).getFlightId());
			classList.add(seatClass);
			
			//좌석들의 가격을 표시하는 구현 - 작업후 나온 결과를 웹페이지로 정보 전달, 2차원 배열
			//가격 정보는 클래스한개씩 검사해서 결과를 가져옴.
			priceClass = seatService.viewSeatPrice(flightList.get(i).getFlightId());

			priceList.add(priceClass);
			//남은 좌석을 가져오기위한 데이터 입력을 하는 작업, 2차원 배열
			seatPot = new ArrayList<Integer>();
			for(int j = 0; j < seatClass.size(); j++) {
				int seatId = classList.get(i).get(j);
				int seatList = seatService.viewSeatRemain(flightList.get(i).getFlightId(), seatId);
				seatPot.add(seatList);
			}
			remainSeat.add(seatPot);
		}
		flightSeatList.put("classList", classList);
		flightSeatList.put("priceList", priceList);
		flightSeatList.put("remainSeat", remainSeat);
		
		model.addAttribute("flightSeatList", flightSeatList);
		//페이지 계산
		int total = flightService.getFlightTotalCnt(departFlyMap);
		System.out.println("총 개수 : " + total);
		model.addAttribute("pageVO", new PageVO(cri, total));
		System.out.println("flightID = " + flightList.get(0).getFlightId());
		
		return "../flight/searchEndFlight";
	}

}
