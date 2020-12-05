package com.yzk.zyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Rw {
	@Id
	@GeneratedValue
	private int id;
	private int zid;
	private String date;
	private String fwlx;
	private int sid;
	private String qwcqk;
	private String hwcqk;
	private String pj;
	private String zt;
	
	public Rw() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getQwcqk() {
		return qwcqk;
	}
	public void setQwcqk(String qwcqk) {
		this.qwcqk = qwcqk;
	}
	public String getHwcqk() {
		return hwcqk;
	}
	public void setHwcqk(String hwcqk) {
		this.hwcqk = hwcqk;
	}
	public String getPj() {
		return pj;
	}
	public void setPj(String pj) {
		this.pj = pj;
	}

	@Override
	public String toString() {
		return "Rw [id=" + id + ", zid=" + zid + ", date=" + date + ", fwlx=" + fwlx + ", sid=" + sid + ", qwcqk="
				+ qwcqk + ", hwcqk=" + hwcqk + ", pj=" + pj + ", zt=" + zt + "]";
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public Rw(int id, int zid, String date, String fwlx, int sid, String qwcqk, String hwcqk, String pj, String zt) {
		super();
		this.id = id;
		this.zid = zid;
		this.date = date;
		this.fwlx = fwlx;
		this.sid = sid;
		this.qwcqk = qwcqk;
		this.hwcqk = hwcqk;
		this.pj = pj;
		this.zt = zt;
	}
	
	
}
