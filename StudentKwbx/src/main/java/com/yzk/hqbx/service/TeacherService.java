package com.yzk.hqbx.service;

import java.util.List;

import com.yzk.hqbx.model.Teacher;

public interface TeacherService {
	Teacher getbyid(int id);

	List<Teacher> findall();

	void del(int id);

	void up(Teacher teacher);

	void add(Teacher teacher);
}
