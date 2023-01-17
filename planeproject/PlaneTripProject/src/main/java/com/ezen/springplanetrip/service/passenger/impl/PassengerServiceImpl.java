package com.ezen.springplanetrip.service.passenger.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springplanetrip.service.passenger.PassengerService;
import com.ezen.springplanetrip.vo.PassengerVO;

@Service
public class PassengerServiceImpl implements PassengerService{
	@Autowired
	private PassengerDAO passengerDAO;
	
	@Override
	public void insertPassenger(PassengerVO passengerVO) {
		
		passengerDAO.insertPassenger(passengerVO);
	}

}