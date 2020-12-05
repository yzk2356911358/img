package com.yzk.model;

public class Order {
	private int id;
	private String name;
	private String tel;
	private String sfz;
	private String hotelname;
	private String money;
	private String date;
	public Order(int id, String name, String tel, String sfz, String hotelname, String money, String date) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.sfz = sfz;
		this.hotelname = hotelname;
		this.money = money;
		this.date = date;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", tel=" + tel + ", sfz=" + sfz + ", hotelname=" + hotelname
				+ ", money=" + money + ", date=" + date + "]";
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
