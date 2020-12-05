package com.yzk.zyz.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yzk.zyz.dao.JgzDao;
import com.yzk.zyz.model.Jgz;
import com.yzk.zyz.service.JgzService;

@Service
public class JgzServiveImp implements JgzService {
	@Autowired
	private JgzDao jgzdao;

	@Override
	public void add(Jgz jgz) {
		jgzdao.save(jgz);
	}

	@Override
	public void del(int id) {
		jgzdao.delete(jgzdao.getOne(id));
	}

	@Override
	public void up(Jgz jgz) {
		Jgz temp = jgzdao.getOne(jgz.getId());
		temp = jgz;
		jgzdao.save(temp);
	}

	@Override
	public Jgz getByname(String name) {
		for (Jgz jgz : jgzdao.findAll()) {
			if (jgz.getName().equals(name)) {
				return jgz;
			}
		}
		return null;
	}

	@Override
	public Jgz getByid(int id) {
		return jgzdao.getOne(id);
	}

}
