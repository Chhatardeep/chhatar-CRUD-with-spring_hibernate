package com.domain;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
		List<DataSaveBo> dataSaveBo= new ArrayList<DataSaveBo>();
		List<DataSaveBo2> dataSaveBo2= new ArrayList<DataSaveBo2>();
		CommonDTO commonDTO = new CommonDTO();
		CommonDTO2 commonDTO2s = new CommonDTO2();
		
		for(int i =1; i<=10; i++)
		{
			DataSaveBo  bo = new DataSaveBo();
			bo.setUtgNumber(i);
			bo.setUtgName("Item "+i);
			bo.setValue(100.0+i);
			dataSaveBo.add(bo);
			commonDTO.setDataSaveBo(bo);
		}
		commonDTO2s.setDataSaveBo(dataSaveBo);
		
		for(int i =1; i<=10; i++)
		{
			DataSaveBo2  bo = new DataSaveBo2();
			bo.setStationNumber(i);
			bo.setStationName("Station"+i);
			bo.setStationvalue(200.0+i);
			dataSaveBo2.add(bo);
			commonDTO.setDataSaveBo2(bo);
			
		}
		commonDTO2s.setDataSaveBo2(dataSaveBo2);
		System.out.println(commonDTO);
		System.out.println(commonDTO2s);
		
	}

}
