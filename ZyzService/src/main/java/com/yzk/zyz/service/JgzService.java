package com.yzk.zyz.service;

import com.yzk.zyz.model.Jgz;

public interface JgzService {

	void add(Jgz jgz);

	void del(int id);

	void up(Jgz jgz);

	Jgz getByname(String name);

	Jgz getByid(int id);
}
