package com.chhatar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chhatar")
public class Alien {

	@Id
	private int aemp;
	private String aname;
	public int getAemp() {
		return aemp;
	}
	public void setAemp(int aemp) {
		this.aemp = aemp;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alien [aemp=" + aemp + ", aname=" + aname + "]";
	}
	
	
}
