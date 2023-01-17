package com.ezen.springplanetrip.vo;

public class AirportVO {
	private int airportId;
	private String airportName;
	private String airportCode;
	private String airportHomepage;
	private String airportTel;
	private String airportHours;
	private int selectedAirportId;
	
	public int getAirportId() {
		return airportId;
	}
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportHomepage() {
		return airportHomepage;
	}
	public void setAirportHomepage(String airportHomepage) {
		this.airportHomepage = airportHomepage;
	}
	public String getAirportTel() {
		return airportTel;
	}
	public void setAirportTel(String airportTel) {
		this.airportTel = airportTel;
	}
	public String getAirportHours() {
		return airportHours;
	}
	public void setAirportHours(String airportHours) {
		this.airportHours = airportHours;
	}
	public int getSelectedAirportId() {
		return selectedAirportId;
	}
	public void setSelectedAirportId(int selectedAirportId) {
		this.selectedAirportId = selectedAirportId;
	}
	
	@Override
	public String toString() {
		return "AirportVO [airportId=" + airportId + ", airportName=" + airportName + ", airportCode=" + airportCode
				+ ", airportHomepage=" + airportHomepage + ", airportTel=" + airportTel + ", airportHours="
				+ airportHours + "]";
	}
	
}
