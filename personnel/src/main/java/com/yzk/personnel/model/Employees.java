package com.yzk.personnel.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employees {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private char sex;
	private Date birthday;
	private int department;

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", department="
				+ department + "]";
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int id, String name, char sex, Date birthday, int department) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.department = department;
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

}
