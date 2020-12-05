package com.yzk.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Kcbxx {
	@Id
	@GeneratedValue
	private int id;
	private String kcname;
	private String bjh;
	private String skjs;
	private String sksj;
	private String sjdd;
	public Kcbxx(int id, String kcname, String bjh, String skjs, String sksj, String sjdd) {
		super();
		this.id = id;
		this.kcname = kcname;
		this.bjh = bjh;
		this.skjs = skjs;
		this.sksj = sksj;
		this.sjdd = sjdd;
	}
	public Kcbxx() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Kcbxx [id=" + id + ", kcname=" + kcname + ", bjh=" + bjh + ", skjs=" + skjs + ", sksj=" + sksj
				+ ", sjdd=" + sjdd + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKcname() {
		return kcname;
	}
	public void setKcname(String kcname) {
		this.kcname = kcname;
	}
	public String getBjh() {
		return bjh;
	}
	public void setBjh(String bjh) {
		this.bjh = bjh;
	}
	public String getSkjs() {
		return skjs;
	}
	public void setSkjs(String skjs) {
		this.skjs = skjs;
	}
	public String getSksj() {
		return sksj;
	}
	public void setSksj(String sksj) {
		this.sksj = sksj;
	}
	public String getSjdd() {
		return sjdd;
	}
	public void setSjdd(String sjdd) {
		this.sjdd = sjdd;
	}
	
}
