package com.yzk.personnel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.personnel.dao.EmployeeDao;
import com.yzk.personnel.dao.UserDao;
import com.yzk.personnel.model.Employees;
import com.yzk.personnel.model.User;
import com.yzk.personnel.service.EmployeeService;
import com.yzk.personnel.service.UserService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void add(Employees employees) {
		employeeDao.save(employees);
	}

	@Override
	public void del(int id) {
		employeeDao.delete(employeeDao.getOne(id));
	}

	@Override
	public void up(Employees employees) {
		Employees temp = employeeDao.getOne(employees.getId());
		temp = employees;
		employeeDao.save(temp);
	}

	@Override
	public List<Employees> findall() {
		return employeeDao.findAll();
	}

}
