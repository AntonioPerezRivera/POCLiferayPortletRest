package com.test.model;

public class WeatherObject {

	private String currentStatus;
	private String currentStatusInfo;
	private float currentTemp;
	private float maxTemp;
	private float minTemp;

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getCurrentStatusInfo() {
		return currentStatusInfo;
	}

	public void setCurrentStatusInfo(String currentStatusInfo) {
		this.currentStatusInfo = currentStatusInfo;
	}

	public float getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(float currentTemp) {
		this.currentTemp = currentTemp;
	}

	public float getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(float maxTemp) {
		this.maxTemp = maxTemp;
	}

	public float getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(float minTemp) {
		this.minTemp = minTemp;
	}

	public WeatherObject(String currentStatus, String currentStatusInfo,
			float currentTemp, float maxTemp, float minTemp) {
		super();
		this.currentStatus = currentStatus;
		this.currentStatusInfo = currentStatusInfo;
		this.currentTemp = currentTemp;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
	}

	public WeatherObject() {
		super();
	}

}
