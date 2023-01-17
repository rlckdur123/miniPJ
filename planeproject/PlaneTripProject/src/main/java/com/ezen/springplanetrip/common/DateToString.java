package com.ezen.springplanetrip.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ezen.springplanetrip.vo.FlightVO;

//비행편의 시간을 문자열로 바꾸기 위한 메소드
public class DateToString {
	public static List<String> changeStringDepartTime(List<FlightVO> target) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		List<String> dateList = new ArrayList<String>();
		for(int i=0; i < target.size(); i++) {
			dateList.add(sdf.format(target.get(i).getDepartTime()));
		}
		return dateList;
	}
	
	public static List<String> changeStringArrivalTime(List<FlightVO> target) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		List<String> dateList = new ArrayList<String>();
		for(int i=0; i < target.size(); i++) {
			dateList.add(sdf.format(target.get(i).getArrivalTime()));
		}
		return dateList;
	}
}
