package com.yzk.personnel.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.personnel.model.Department;
import com.yzk.personnel.service.DepartmentService;

@Controller
@RequestMapping
public class DepartmentControl {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/adddep")
	public String index(Department department, Model model) {
		departmentService.add(department);
		model.addAttribute("list", departmentService.findall());
		return "departmentlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/deldep")
	public String deldep(int id, Model model) {
		departmentService.del(id);
		model.addAttribute("list", departmentService.findall());
		return "departmentlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/getdep")
	public String getdep(int id, Model model) {
		for (Department department : departmentService.findall()) {
			if (department.getId() == id) {
				model.addAttribute("dep", department);
			}
		}
		return "updep";// 返回到HTML页面
	}

	@RequestMapping(value = "/deplist")
	public String deplist(Model model) {
		model.addAttribute("list", departmentService.findall());
		return "departmentlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/updep")
	public String updep(Model model, Department department) {
		departmentService.up(department);
		model.addAttribute("list", departmentService.findall());
		return "departmentlist";// 返回到HTML页面
	}

}
