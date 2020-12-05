package com.yzk.hqbx.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.hqbx.dao.TeacherDao;
import com.yzk.hqbx.model.Teacher;
import com.yzk.hqbx.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	public Teacher getbyid(int id) {
		return teacherDao.getbyid(id);
	}

	public List<Teacher> findall() {
		return teacherDao.findall();
	}

	public void del(int id) {
		teacherDao.del(id);
	}

	public void up(Teacher teacher) {
		teacherDao.up(teacher);
	}

	public void add(Teacher teacher) {
		teacherDao.add(teacher);
	}

}
