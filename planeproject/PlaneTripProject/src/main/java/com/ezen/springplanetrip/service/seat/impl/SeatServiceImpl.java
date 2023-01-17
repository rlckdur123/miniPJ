package com.ezen.springplanetrip.service.seat.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.seat.SeatService;
import com.ezen.springplanetrip.vo.SeatVO;

@Service
public class SeatServiceImpl implements SeatService{
	@Autowired
	private SeatDAO seatDAO;
	
	@Override
	public List<SeatVO> viewSeatList(int flightId) {
		return seatDAO.viewSeatList(flightId);
	}
	
	@Override
	public List<Integer> viewSeatCount(int flightId) {
		return seatDAO.viewSeatCount(flightId);
	}
	
	@Override
	public int viewSeatRemain(int flightId, int seatId) {
		return seatDAO.viewSeatRemain(flightId, seatId);
	}
	
	@Override
	public List<Integer> viewSeatClass(int flightId) {
		return seatDAO.viewSeatClass(flightId);
	}
	
	@Override
	public List<Integer> viewSeatPrice(int flightId) {
		return seatDAO.viewSeatPrice(flightId);
	}
}
