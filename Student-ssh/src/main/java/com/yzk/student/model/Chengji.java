package com.yzk.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chengji {
	@Id
	@GeneratedValue
	private int id;
	private int xh;
	private String kch;
	private String fs;

	public Chengji(int id, int xh, String kch, String fs) {
		super();
		this.id = id;
		this.xh = xh;
		this.kch = kch;
		this.fs = fs;
	}

	public Chengji() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Chengji [id=" + id + ", xh=" + xh + ", kch=" + kch + ", fs=" + fs + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}

	public String getKch() {
		return kch;
	}

	public void setKch(String kch) {
		this.kch = kch;
	}

	public String getFs() {
		return fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}

}
