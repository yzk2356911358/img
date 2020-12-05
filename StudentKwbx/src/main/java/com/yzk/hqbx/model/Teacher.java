package com.yzk.hqbx.model;

public class Teacher {
	private int id;
	private String name;
	private String password;
	private String classs;
	private String kcname;
	private String kcdj;

	public Teacher(int id, String name, String password, String classs, String kcname, String kcdj) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.classs = classs;
		this.kcname = kcname;
		this.kcdj = kcdj;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", password=" + password + ", classs=" + classs + ", kcname="
				+ kcname + ", kcdj=" + kcdj + "]";
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

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getKcname() {
		return kcname;
	}

	public void setKcname(String kcname) {
		this.kcname = kcname;
	}

	public String getKcdj() {
		return kcdj;
	}

	public void setKcdj(String kcdj) {
		this.kcdj = kcdj;
	}

}
