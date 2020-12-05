package com.yzk.zyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Zyz {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String email;
	private String gj;
	private String name;
	private String card;
	private String gender;
	private String zzmm;
	private String mz;
	private String jg;
	private String tel;
	private String addres;
	private String xl;
	private String cyzk;
	private String fwqu;
	private String fwhy;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getCyzk() {
		return cyzk;
	}

	public void setCyzk(String cyzk) {
		this.cyzk = cyzk;
	}

	public String getFwqu() {
		return fwqu;
	}

	public void setFwqu(String fwqu) {
		this.fwqu = fwqu;
	}

	public String getFwhy() {
		return fwhy;
	}

	public void setFwhy(String fwhy) {
		this.fwhy = fwhy;
	}

	@Override
	public String toString() {
		return "Zyz [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", gj=" + gj
				+ ", name=" + name + ", card=" + card + ", gender=" + gender + ", zzmm=" + zzmm + ", mz=" + mz + ", jg="
				+ jg + ", tel=" + tel + ", addres=" + addres + ", xl=" + xl + ", cyzk=" + cyzk + ", fwqu=" + fwqu
				+ ", fwhy=" + fwhy + "]";
	}

}
