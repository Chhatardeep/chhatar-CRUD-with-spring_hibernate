package com.domain;

import java.io.Serializable;

public class CommonDTO implements Serializable {
	
	DataSaveBo dataSaveBo;
	DataSaveBo2 dataSaveBo2;
	
	public DataSaveBo getDataSaveBo() {
		return dataSaveBo;
	}
	public void setDataSaveBo(DataSaveBo dataSaveBo) {
		this.dataSaveBo = dataSaveBo;
	}
	public DataSaveBo2 getDataSaveBo2() {
		return dataSaveBo2;
	}
	public void setDataSaveBo2(DataSaveBo2 dataSaveBo2) {
		this.dataSaveBo2 = dataSaveBo2;
	}
	
}
