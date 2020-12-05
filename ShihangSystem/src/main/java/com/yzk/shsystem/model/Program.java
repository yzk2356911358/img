package com.yzk.shsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Program {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private int price;
	private String info;
	private String infoimg1;
	private String infoimg2;
	private String infoimg3;
	private String infoimg4;
	private String infoimg5;
	private String infoimg6;
	private String infoimg7;
	private String infoimg8;
	private String url;
	private String classify;

	public Program() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", title=" + title + ", price=" + price + ", info=" + info + ", infoimg1="
				+ infoimg1 + ", infoimg2=" + infoimg2 + ", infoimg3=" + infoimg3 + ", infoimg4=" + infoimg4
				+ ", infoimg5=" + infoimg5 + ", infoimg6=" + infoimg6 + ", infoimg7=" + infoimg7 + ", infoimg8="
				+ infoimg8 + ", url=" + url + ", classify=" + classify + "]";
	}

	public Program(int id, String title, int price, String info, String infoimg1, String infoimg2, String infoimg3,
			String infoimg4, String infoimg5, String infoimg6, String infoimg7, String infoimg8, String url,
			String classify) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.info = info;
		this.infoimg1 = infoimg1;
		this.infoimg2 = infoimg2;
		this.infoimg3 = infoimg3;
		this.infoimg4 = infoimg4;
		this.infoimg5 = infoimg5;
		this.infoimg6 = infoimg6;
		this.infoimg7 = infoimg7;
		this.infoimg8 = infoimg8;
		this.url = url;
		this.classify = classify;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfoimg1() {
		return infoimg1;
	}

	public void setInfoimg1(String infoimg1) {
		this.infoimg1 = infoimg1;
	}

	public String getInfoimg2() {
		return infoimg2;
	}

	public void setInfoimg2(String infoimg2) {
		this.infoimg2 = infoimg2;
	}

	public String getInfoimg3() {
		return infoimg3;
	}

	public void setInfoimg3(String infoimg3) {
		this.infoimg3 = infoimg3;
	}

	public String getInfoimg4() {
		return infoimg4;
	}

	public void setInfoimg4(String infoimg4) {
		this.infoimg4 = infoimg4;
	}

	public String getInfoimg5() {
		return infoimg5;
	}

	public void setInfoimg5(String infoimg5) {
		this.infoimg5 = infoimg5;
	}

	public String getInfoimg6() {
		return infoimg6;
	}

	public void setInfoimg6(String infoimg6) {
		this.infoimg6 = infoimg6;
	}

	public String getInfoimg7() {
		return infoimg7;
	}

	public void setInfoimg7(String infoimg7) {
		this.infoimg7 = infoimg7;
	}

	public String getInfoimg8() {
		return infoimg8;
	}

	public void setInfoimg8(String infoimg8) {
		this.infoimg8 = infoimg8;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

}
