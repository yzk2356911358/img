package com.yzk.hqbx.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.hqbx.dao.CzyDao;
import com.yzk.hqbx.model.Czy;
import com.yzk.hqbx.service.CzyService;
@Service
public class CzyServiceImp implements CzyService{
	@Autowired
	private CzyDao czyDao;
	public Czy getbyid(int id) {
		return czyDao.getbyid(id);
	}

	public List<Czy> findall() {
		return czyDao.findall();
	}

	public void del(int id) {
		czyDao.del(id);
	}

	public void up(Czy czy ) {
		czyDao.up(czy);
	}

	public void add(Czy czy) {
		czyDao.add(czy);
	}
	
}
