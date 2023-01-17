package com.ezen.springplanetrip.service.aircraft.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AircraftDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
}
