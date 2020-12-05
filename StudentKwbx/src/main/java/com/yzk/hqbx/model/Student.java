package com.yzk.hqbx.model;

public class Student {
	private int id;
	private String name;
	private String password;
	private String teacher;

	public Student(int id, String name, String password, String teacher) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.teacher = teacher;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", teacher=" + teacher + "]";
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
