package com.domain;

import java.io.Serializable;

public class DataSaveBo implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private Integer utgNumber;
private String utgName;
private Double value;

public Integer getUtgNumber() {
	return utgNumber;
}
public void setUtgNumber(Integer utgNumber) {
	this.utgNumber = utgNumber;
}
public String getUtgName() {
	return utgName;
}
public void setUtgName(String utgName) {
	this.utgName = utgName;
}
public Double getValue() {
	return value;
}
public void setValue(Double value) {
	this.value = value;
}


}
