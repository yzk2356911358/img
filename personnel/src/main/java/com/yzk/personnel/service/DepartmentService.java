package com.yzk.personnel.service;

import java.util.List;

import com.yzk.personnel.model.Department;
import com.yzk.personnel.model.User;

public interface DepartmentService {
	void add(Department department);

	void del(int id);

	void up(Department department);

	List<Department> findall();
}
