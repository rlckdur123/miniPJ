package com.ezen.springplanetrip.service.passenger;

import org.springframework.ui.Model;

import com.ezen.springplanetrip.vo.PassengerVO;

public interface PassengerService {
	//승객 정보 입력
	void insertPassenger(PassengerVO passengerVO);
}