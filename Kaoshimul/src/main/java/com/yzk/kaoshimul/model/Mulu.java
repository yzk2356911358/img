package com.yzk.kaoshimul.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mulu {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String name;
	private String date;
	private String fenlei;
	public Mulu(int id, String title, String name, String date, String fenlei) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.date = date;
		this.fenlei = fenlei;
	}
	public Mulu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Mulu [id=" + id + ", title=" + title + ", name=" + name + ", date=" + date + ", fenlei=" + fenlei + "]";
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
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
}
