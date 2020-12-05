package com.yzk.personnel.service;

import java.util.List;

import com.yzk.personnel.model.Department;
import com.yzk.personnel.model.Employees;
import com.yzk.personnel.model.User;

public interface EmployeeService {
	void add(Employees employees);

	void del(int id);

	void up(Employees employees);

	List<Employees> findall();
}
