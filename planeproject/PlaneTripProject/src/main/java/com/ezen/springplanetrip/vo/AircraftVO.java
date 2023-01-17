package com.ezen.springplanetrip.vo;

public class AircraftVO {
	private int aircraftId;
	private String aircraftModel;
	private String aircraftMFR;
	
	public int getAircraftId() {
		return aircraftId;
	}
	public void setAircraftId(int aircraftId) {
		this.aircraftId = aircraftId;
	}
	public String getAircraftModel() {
		return aircraftModel;
	}
	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}
	public String getAircraftMFR() {
		return aircraftMFR;
	}
	public void setAircraftMFR(String aircraftMFR) {
		this.aircraftMFR = aircraftMFR;
	}
	
	@Override
	public String toString() {
		return "AircraftVO [aircraftId=" + aircraftId + ", aircraftModel=" + aircraftModel + ", aircraftMFR="
				+ aircraftMFR + "]";
	}
	
	
}
