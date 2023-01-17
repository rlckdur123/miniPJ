package com.ezen.springplanetrip.vo;

/*java.sql.Date 대신 좀 더 자세한 util.Date 선택.
특정 문자열 포맷으로 얻고 싶으면 java.text.SimpleDateFormat 클래스를 이용*/
import java.util.Date;

public class FlightVO {
	private int flightId;
	private String flightCode;
	private Date departTime;
	private Date arrivalTime; 
	private int aircraftId;
	private String airportDpt;
	private String airportArv;
	
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Date getDepartTime() {
		return departTime;
	}
	
	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getAircraftId() {
		return aircraftId;
	}
	
	public void setAircraftId(int aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getAirportDpt() {
		return airportDpt;
	}

	public void setAirportDpt(String airportDpt) {
		this.airportDpt = airportDpt;
	}

	public String getAirportArv() {
		return airportArv;
	}

	public void setAirportArv(String airportArv) {
		this.airportArv = airportArv;
	}

	@Override
	public String toString() {
		return "FlightVO [flightId=" + flightId + ", flightCode=" + flightCode + ", departTime=" + departTime
				+ ", arrivalTime=" + arrivalTime + ", aircraftId=" + aircraftId + ", airportDpt=" + airportDpt
				+ ", airportArv=" + airportArv + "]";
	}

	
}
