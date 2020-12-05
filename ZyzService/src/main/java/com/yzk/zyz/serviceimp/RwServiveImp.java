package com.yzk.zyz.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.zyz.dao.RwDao;
import com.yzk.zyz.model.Rw;
import com.yzk.zyz.service.RwService;

@Service
public class RwServiveImp implements RwService {
	@Autowired
	private RwDao rwDao;

	@Override
	public void add(Rw rw) {
		rwDao.save(rw);
	}

	@Override
	public void del(int id) {
		rwDao.delete(rwDao.getOne(id));
	}

	@Override
	public void up(Rw rw) {
		Rw temp = rwDao.getOne(rw.getId());
		temp = rw;
		rwDao.save(temp);
	}

	@Override
	public List<Rw> getByzid(int zid, String zt) {
		System.out.println("执行");
		List<Rw> list = new ArrayList<>();
		for (Rw rw : rwDao.findAll()) {
			System.out.println(rw.getZt()+zt);
			if (rw.getZid() == zid && rw.getZt().equals(zt)) {
				list.add(rw);
			}
		}

		return list;
	}

	@Override
	public List<Rw> getBysid(int sid) {
		List<Rw> list = new ArrayList<>();
		for (Rw rw : rwDao.findAll()) {
			if (rw.getSid() == sid) {
				list.add(rw);
			}
		}
		return list;
	}

	@Override
	public void up(Rw rw, String zt) {
		Rw temp = rwDao.getOne(rw.getId());
		temp.setZt(zt);
		rwDao.save(temp);
	}

	@Override
	public Rw getbyid(int id) {
		return rwDao.getOne(id);
	}

	@Override
	public List<Rw> findall() {
		return rwDao.findAll();
	}

}
