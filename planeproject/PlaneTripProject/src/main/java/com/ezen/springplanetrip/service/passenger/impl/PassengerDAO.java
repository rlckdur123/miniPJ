package com.ezen.springplanetrip.service.passenger.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.ezen.springplanetrip.vo.PassengerVO;

@Repository
public class PassengerDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertPassenger(PassengerVO passengerVO) {
		System.out.println("mybatis 작업 시작");
		System.out.println(passengerVO);
		mybatis.insert("PassengerDAO.insertPassenger", passengerVO);
	}
}