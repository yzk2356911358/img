package com.yzk.dao;

import java.util.List;

import com.yzk.model.Admin;

public interface AdminDao {
	List<Admin> findall();

	Admin getbyid(int id);

	void del(int id);

	void add(Admin admin);

	void up(Admin admin);

}
