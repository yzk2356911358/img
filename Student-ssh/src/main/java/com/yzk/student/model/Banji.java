package com.yzk.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Banji {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String zy;
	private int rs;
	private String rxnf;
	private String fdy;
	public Banji(int id, String name, String zy, int rs, String rxnf, String fdy) {
		super();
		this.id = id;
		this.name = name;
		this.zy = zy;
		this.rs = rs;
		this.rxnf = rxnf;
		this.fdy = fdy;
	}
	public Banji() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", zy=" + zy + ", rs=" + rs + ", rxnf=" + rxnf + ", fdy=" + fdy
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	public String getRxnf() {
		return rxnf;
	}
	public void setRxnf(String rxnf) {
		this.rxnf = rxnf;
	}
	public String getFdy() {
		return fdy;
	}
	public void setFdy(String fdy) {
		this.fdy = fdy;
	}
	
}
