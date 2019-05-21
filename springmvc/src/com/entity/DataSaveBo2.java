package com.entity;

import java.io.Serializable;

public class DataSaveBo2 implements Serializable {
	private Integer StationNumber;
	private String StationName;
	private Double Stationvalue;
	public Integer getStationNumber() {
		return StationNumber;
	}
	public void setStationNumber(Integer stationNumber) {
		StationNumber = stationNumber;
	}
	public String getStationName() {
		return StationName;
	}
	public void setStationName(String stationName) {
		StationName = stationName;
	}
	public Double getStationvalue() {
		return Stationvalue;
	}
	public void setStationvalue(Double stationvalue) {
		Stationvalue = stationvalue;
	}
	
}
