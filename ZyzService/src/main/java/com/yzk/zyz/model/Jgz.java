package com.yzk.zyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Jgz {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	private int syzid;
	public Jgz(int id, String name, String password, int syzid) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.syzid = syzid;
	}
	public Jgz() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Jgz [id=" + id + ", name=" + name + ", password=" + password + ", syzid=" + syzid + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSyzid() {
		return syzid;
	}
	public void setSyzid(int syzid) {
		this.syzid = syzid;
	}


}
