package com.yzk.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yzk.employee.dao.DepartmentDao;

@Controller
@RequestMapping
public class DepartmentControl {
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";// 返回到HTML页面
	}

}
