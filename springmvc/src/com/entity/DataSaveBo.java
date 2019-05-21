package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DATA_SAVE_BO")
public class DataSaveBo {

	@Id
	private Integer utgNumber;

	@Column(name = "UTG_NAME")
	private String utgName;

	@Column(name = "VALUE")
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
