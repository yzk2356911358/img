package com.yzk.shopsystem.model;

public class Shop {
	private int id;
	private String img;
	private String name;
	private String jg;
	private String xl;
	private String kd;
	private String fl;
	public Shop(int id, String img, String name, String jg, String xl, String kd, String fl) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.jg = jg;
		this.xl = xl;
		this.kd = kd;
		this.fl = fl;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", img=" + img + ", name=" + name + ", jg=" + jg + ", xl=" + xl + ", kd=" + kd
				+ ", fl=" + fl + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getKd() {
		return kd;
	}
	public void setKd(String kd) {
		this.kd = kd;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
		
}
