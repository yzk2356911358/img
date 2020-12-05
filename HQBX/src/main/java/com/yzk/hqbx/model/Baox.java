package com.yzk.hqbx.model;

public class Baox {
	private int id;
	private String name;
	private String date;
	private String addres;
	private int sl;
	private String shcd;
	private String wname;
	private String wdate;
	private String wyzname;
	private String wwxqk;
	private String ys;

	public Baox(int id, String name, String date, String addres, int sl, String shcd, String wname, String wdate,
			String wyzname, String wwxqk, String ys) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.addres = addres;
		this.sl = sl;
		this.shcd = shcd;
		this.wname = wname;
		this.wdate = wdate;
		this.wyzname = wyzname;
		this.wwxqk = wwxqk;
		this.ys = ys;
	}

	public Baox() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Baox [id=" + id + ", name=" + name + ", date=" + date + ", addres=" + addres + ", sl=" + sl + ", shcd="
				+ shcd + ", wname=" + wname + ", wdate=" + wdate + ", wyzname=" + wyzname + ", wwxqk=" + wwxqk + ", ys="
				+ ys + "]";
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public String getShcd() {
		return shcd;
	}

	public void setShcd(String shcd) {
		this.shcd = shcd;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getWyzname() {
		return wyzname;
	}

	public void setWyzname(String wyzname) {
		this.wyzname = wyzname;
	}

	public String getWwxqk() {
		return wwxqk;
	}

	public void setWwxqk(String wwxqk) {
		this.wwxqk = wwxqk;
	}

	public String getYs() {
		return ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}

}
