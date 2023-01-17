package com.ezen.springplanetrip.service.reservation;

import java.util.List;
import java.util.Map;

import com.ezen.springplanetrip.vo.ReservationVO;

public interface ReservationService {
	List<Integer> getPassengerList(int userId, int passengerCnt);
	
	List<String> getSeatNoList(Map<String, Object> seatNoMap);
	
	void insertReservation(List<ReservationVO> fwdList, List<ReservationVO> bwdList);
	
	int getReservationId();
	
}
