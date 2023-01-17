package com.ezen.springplanetrip.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springplanetrip.service.reservation.ReservationService;
import com.ezen.springplanetrip.vo.ReservationVO;
import com.ezen.springplanetrip.vo.UserVO;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/insertReservation.do")
	public String insertReservation(@RequestParam Map<String, Object> rsv, Model model, HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		int userId = 0;
		
		if(userVO != null) {
			userId = userVO.getUserId();
		}
		
//		Iterator<String> keySet = rsv.keySet().iterator();
//		
//		Map<String, Object> fwdMap = new HashMap<String, Object>();
//		Map<String, Object> bwdMap = new HashMap<String, Object>();
//		
//		while(keySet.hasNext()) {
//			String key = keySet.next();
//			
//			if(key.startsWith("fwd")) {
//				fwdMap.put(key, rsv.get(key));
//			} else if(key.startsWith("bwd")) {
//				bwdMap.put(key, rsv.get(key));
//			}
//		}
		
		int passengerCnt = Integer.parseInt(rsv.get("passengerCnt").toString());
		
		List<Integer> passengerList = reservationService.getPassengerList(userId, passengerCnt);
		
		Map<String, Object> fwdSeatNoMap = new HashMap<String, Object>();
		fwdSeatNoMap.put("flightId", rsv.get("fwd_flight_id"));
		fwdSeatNoMap.put("seatId", rsv.get("fwd_seat_id"));
		fwdSeatNoMap.put("passengerCnt", passengerCnt);
		
		Map<String, Object> bwdSeatNoMap = new HashMap<String, Object>();
		bwdSeatNoMap.put("flightId", rsv.get("bwd_flight_id"));
		bwdSeatNoMap.put("seatId", rsv.get("bwd_seat_id"));
		bwdSeatNoMap.put("passengerCnt", passengerCnt);
		
		List<String> fwdSeatNoList = reservationService.getSeatNoList(fwdSeatNoMap);
		List<String> bwdSeatNoList = reservationService.getSeatNoList(bwdSeatNoMap);		
		
		List<ReservationVO> fwdList = new ArrayList<ReservationVO>();
		List<ReservationVO> bwdList = new ArrayList<ReservationVO>();
		
		int reservationId = reservationService.getReservationId();
		
		for(int i = 0; i < passengerCnt; i++) { 
			ReservationVO fwdReservationVO = new ReservationVO();
			ReservationVO bwdReservationVO = new ReservationVO();
			
			fwdReservationVO.setReservationId(reservationId);
			bwdReservationVO.setReservationId(reservationId);
			
			fwdReservationVO.setFlightId(Integer.parseInt(rsv.get("fwd_flight_id").toString()));
			bwdReservationVO.setFlightId(Integer.parseInt(rsv.get("bwd_flight_id").toString()));
			
			fwdReservationVO.setSeatId(Integer.parseInt(rsv.get("fwd_seat_id").toString()));
			bwdReservationVO.setSeatId(Integer.parseInt(rsv.get("bwd_seat_id").toString()));
			
			fwdReservationVO.setPassengerId(passengerList.get(i));
			bwdReservationVO.setPassengerId(passengerList.get(i));
			
			fwdReservationVO.setSeatNo(fwdSeatNoList.get(i));
			bwdReservationVO.setSeatNo(bwdSeatNoList.get(i));
			
			fwdReservationVO.setUserId(userId);
			bwdReservationVO.setUserId(userId);
			
			fwdReservationVO.setDepartDatetime(rsv.get("fwd_depart_datetime").toString());
			fwdReservationVO.setArrivalDatetime(rsv.get("fwd_arrival_datetime").toString());
			bwdReservationVO.setDepartDatetime(rsv.get("bwd_depart_datetime").toString());
			bwdReservationVO.setArrivalDatetime(rsv.get("bwd_arrival_datetime").toString());
			
			fwdList.add(fwdReservationVO);
			bwdList.add(bwdReservationVO);
		}
		
		reservationService.insertReservation(fwdList, bwdList);
		
		return "reservation/confirmReservation";
	}
}
