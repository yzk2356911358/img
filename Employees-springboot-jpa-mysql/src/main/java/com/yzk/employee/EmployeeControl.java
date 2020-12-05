package com.yzk.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class EmployeeControl {
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String employeelist(Model model) {
		return "employeelist";// 返回到HTML页面
	}
	
}
