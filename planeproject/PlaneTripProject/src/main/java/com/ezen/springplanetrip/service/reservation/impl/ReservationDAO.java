package com.ezen.springplanetrip.service.reservation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.springplanetrip.vo.ReservationVO;

@Repository
public class ReservationDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Integer> getPassengerList(int userId, int passengerCnt) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userId", userId);
		paramMap.put("passengerCnt", passengerCnt);
		
		return mybatis.selectList("ReservationDAO.getPassengerList", paramMap);
	}
	
	public List<String> getSeatNoList(Map<String, Object> seatNoMap) {
		// TODO Auto-generated method stub
		return mybatis.selectList("ReservationDAO.getSeatNoList", seatNoMap);
	}
	
	public void insertReservation(List<ReservationVO> fwdList, List<ReservationVO> bwdList) {
		// TODO Auto-generated method stub
		mybatis.insert("ReservationDAO.insertReservation", fwdList);
		mybatis.insert("ReservationDAO.insertReservation", bwdList);
	}
	
	public int getReservationId() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("ReservationDAO.getReservationId");
	}

}
