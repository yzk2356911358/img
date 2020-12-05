package com.yzk.zyz.service;

import java.util.List;

import com.yzk.zyz.model.Zyz;

public interface ZyzService {

	void add(Zyz zyz);

	void del(int id);

	void up(Zyz zyz);
	List<Zyz> findall();
	Zyz getByusername(String username);

	Zyz getByid(int id);
}
