package com.yzk.zyz.service;

import com.yzk.zyz.model.Syz;

public interface SyzService {

	void add(Syz syz);

	void del(int id);

	void up(Syz syz);

	Syz getByname(String name);

	Syz getByid(int id);
}
