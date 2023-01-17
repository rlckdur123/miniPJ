package com.ezen.springplanetrip.service.reservation.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.reservation.ReservationService;
import com.ezen.springplanetrip.vo.ReservationVO;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	public List<Integer> getPassengerList(int userId, int passengerCnt) {
		// TODO Auto-generated method stub
		return reservationDAO.getPassengerList(userId, passengerCnt);
	}

	@Override
	public List<String> getSeatNoList(Map<String, Object> seatNoMap) {
		// TODO Auto-generated method stub
		return reservationDAO.getSeatNoList(seatNoMap);
	}

	@Override
	public void insertReservation(List<ReservationVO> fwdList, List<ReservationVO> bwdList) {
		// TODO Auto-generated method stub
		reservationDAO.insertReservation(fwdList, bwdList);
	}

	@Override
	public int getReservationId() {
		// TODO Auto-generated method stub
		return reservationDAO.getReservationId();
	}
	
}
