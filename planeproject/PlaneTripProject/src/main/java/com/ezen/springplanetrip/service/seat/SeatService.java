package com.ezen.springplanetrip.service.seat;

import java.util.List;
import java.util.Map;

import com.ezen.springplanetrip.vo.SeatVO;

public interface SeatService {
	List<SeatVO> viewSeatList(int flightId);
	
	List<Integer> viewSeatCount(int flightId);
	
	int viewSeatRemain(int flightId, int seatId);
	
	List<Integer> viewSeatClass(int flightId);
	
	List<Integer> viewSeatPrice(int flightId);
}
