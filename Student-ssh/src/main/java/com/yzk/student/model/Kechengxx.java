package com.yzk.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Kechengxx {
	@Id
	private int id;
	private String name;
	private String xs;
	private String xf;
	public Kechengxx(int id, String name, String xs, String xf) {
		super();
		this.id = id;
		this.name = name;
		this.xs = xs;
		this.xf = xf;
	}
	public Kechengxx() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Kechengxx [id=" + id + ", name=" + name + ", xs=" + xs + ", xf=" + xf + "]";
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
	public String getXs() {
		return xs;
	}
	public void setXs(String xs) {
		this.xs = xs;
	}
	public String getXf() {
		return xf;
	}
	public void setXf(String xf) {
		this.xf = xf;
	}
	
}
