package com.yzk.personnel.control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.yzk.personnel.model.Employees;
import com.yzk.personnel.service.DepartmentService;
import com.yzk.personnel.service.EmployeeService;

@Controller
@RequestMapping
public class EmployeeControl {
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/addemp")
	public String index(String name, char sex, int department, Date date, Model model) {
		Employees employees = new Employees(0, name, sex, date, department);
		System.out.println(employees);
		employeeservice.add(employees);
		model.addAttribute("list", employeeservice.findall());
		return "employeelist";// 返回到HTML页面
	}
	@RequestMapping(value = "/addemppage")
	public String addemppage(Model model) {
		model.addAttribute("list", departmentService.findall());
		return "addemployee";// 返回到HTML页面
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}

	@RequestMapping(value = "/emplist")
	public String emplist(Model model) {
		model.addAttribute("list", employeeservice.findall());
		return "employeelist";// 返回到HTML页面
	}

	@RequestMapping(value = "/delemp")
	public String delemp(Model model, int id) {
		employeeservice.del(id);
		model.addAttribute("list", employeeservice.findall());
		return "employeelist";// 返回到HTML页面
	}
	
	@RequestMapping(value = "/upemp")
	public String upemp(int id,String name, char sex, int department, Date date, Model model) {
		Employees employees = new Employees(id, name, sex, date, department);
		employeeservice.up(employees);
		model.addAttribute("list", employeeservice.findall());
		return "employeelist";// 返回到HTML页面
	}
	@InitBinder
	public void initBinder1(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}
	@RequestMapping(value = "/getemp")
	public String getemp(Model model, int id) {
		for (Employees employees : employeeservice.findall()) {
			if (employees.getId() == id) {
				model.addAttribute("emp", employees);
				return "upemp";// 返回到HTML页面
			}
		}
		model.addAttribute("emp", employeeservice.findall());
		return "employeelist";// 返回到HTML页面
	}
}
