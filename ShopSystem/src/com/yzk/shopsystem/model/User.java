package com.yzk.shopsystem.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String gender;
	private String tel;
	private String email;
	private String addres;

	public User(int id, String username, String password, String gender, String tel, String email, String addres) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.tel = tel;
		this.email = email;
		this.addres = addres;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender + ", tel="
				+ tel + ", email=" + email + ", addres=" + addres + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

}
