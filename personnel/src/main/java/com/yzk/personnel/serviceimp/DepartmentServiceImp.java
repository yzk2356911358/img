package com.yzk.personnel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.personnel.dao.DepartmentDao;
import com.yzk.personnel.dao.UserDao;
import com.yzk.personnel.model.Department;
import com.yzk.personnel.model.User;
import com.yzk.personnel.service.DepartmentService;
import com.yzk.personnel.service.UserService;

@Service
public class DepartmentServiceImp implements DepartmentService {
	@Autowired
	private DepartmentDao userdao;

	@Override
	public void add(Department department) {
		userdao.save(department);
	}

	@Override
	public void del(int id) {
		userdao.delete(userdao.getOne(id));
	}

	@Override
	public void up(Department department) {
		Department temp = userdao.getOne(department.getId());
		temp = department;
		userdao.save(temp);
	}

	@Override
	public List<Department> findall() {
		return userdao.findAll();
	}

}
