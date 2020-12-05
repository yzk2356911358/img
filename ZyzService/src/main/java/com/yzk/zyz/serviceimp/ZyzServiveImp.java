package com.yzk.zyz.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.zyz.dao.ZyzDao;
import com.yzk.zyz.model.Zyz;
import com.yzk.zyz.service.ZyzService;

@Service
public class ZyzServiveImp implements ZyzService {
	@Autowired
	private ZyzDao zyzdao;

	@Override
	public void add(Zyz zyz) {
		zyzdao.save(zyz);
	}

	@Override
	public void del(int id) {
		zyzdao.delete(zyzdao.getOne(id));
	}

	@Override
	public void up(Zyz zyz) {
		Zyz temp = zyzdao.getOne(zyz.getId());
		temp = zyz;
		zyzdao.save(temp);
	}

	@Override
	public Zyz getByusername(String username) {
		for (Zyz zyz : zyzdao.findAll()) {
			if (zyz.getUsername().equals(username)) {
				return zyz;
			}
		}
		return null;
	}

	@Override
	public Zyz getByid(int id) {
		return zyzdao.getOne(id);
	}

	@Override
	public List<Zyz> findall() {
		return zyzdao.findAll();
	}

}
