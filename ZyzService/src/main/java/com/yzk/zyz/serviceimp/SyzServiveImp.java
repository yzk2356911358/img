package com.yzk.zyz.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.zyz.dao.SyzDao;
import com.yzk.zyz.model.Syz;
import com.yzk.zyz.service.SyzService;

@Service
public class SyzServiveImp implements SyzService {
	@Autowired
	private SyzDao syzdao;

	@Override
	public void add(Syz syz) {
		syzdao.save(syz);
	}

	@Override
	public void del(int id) {
		syzdao.delete(syzdao.getOne(id));
	}

	@Override
	public void up(Syz syz) {
		Syz temp = syzdao.getOne(syz.getId());
		temp = syz;
		syzdao.save(temp);
	}

	@Override
	public Syz getByname(String name) {
		for (Syz syz : syzdao.findAll()) {
			if (syz.getName().equals(name)) {
				return syz;
			}
		}
		return null;
	}

	@Override
	public Syz getByid(int id) {
		return syzdao.getOne(id);
	}

}
