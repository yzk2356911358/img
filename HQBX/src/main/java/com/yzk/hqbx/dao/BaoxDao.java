package com.yzk.hqbx.dao;

import java.util.List;

import com.yzk.hqbx.model.Baox;

public interface BaoxDao {
	Baox getbyid(int id);

	List<Baox> findall();

	void del(int id);

	void up(Baox baox);

	void add(Baox baox);
}
