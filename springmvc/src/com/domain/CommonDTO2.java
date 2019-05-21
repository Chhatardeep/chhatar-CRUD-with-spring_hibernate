package com.domain;

import java.io.Serializable;
import java.util.List;

public class CommonDTO2 implements Serializable {
	
	List<DataSaveBo> dataSaveBo;
	List<DataSaveBo2> dataSaveBo2;
	public List<DataSaveBo> getDataSaveBo() {
		return dataSaveBo;
	}
	public void setDataSaveBo(List<DataSaveBo> dataSaveBo) {
		this.dataSaveBo = dataSaveBo;
	}
	public List<DataSaveBo2> getDataSaveBo2() {
		return dataSaveBo2;
	}
	public void setDataSaveBo2(List<DataSaveBo2> dataSaveBo2) {
		this.dataSaveBo2 = dataSaveBo2;
	}
	

}
