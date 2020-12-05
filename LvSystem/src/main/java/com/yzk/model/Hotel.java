package com.yzk.model;

public class Hotel {
	private int id;
	private String title;
	private double money;
	private String img;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int id, String title, double money, String img) {
		super();
		this.id = id;
		this.title = title;
		this.money = money;
		this.img = img;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", title=" + title + ", money=" + money + ", img=" + img + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
