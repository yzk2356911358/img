package com.yzk.zyz.service;

import java.util.List;

import com.yzk.zyz.model.Rw;

public interface RwService {

	void add(Rw rw);

	void del(int id);

	void up(Rw rw);

	void up(Rw rw, String zt);

	Rw getbyid(int id);

	List<Rw> getByzid(int zid, String zt);

	List<Rw> getBysid(int sid);
	List<Rw> findall();
}
