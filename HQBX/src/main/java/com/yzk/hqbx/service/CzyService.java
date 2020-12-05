package com.yzk.hqbx.service;

import java.util.List;

import com.yzk.hqbx.model.Czy;

public interface CzyService {
	Czy getbyid(int id);

	List<Czy> findall();

	void del(int id);

	void up(Czy czy);

	void add(Czy czy);
}
