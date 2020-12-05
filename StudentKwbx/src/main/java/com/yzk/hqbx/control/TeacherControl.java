package com.yzk.hqbx.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.hqbx.model.User;
import com.yzk.hqbx.service.StudentService;
import com.yzk.hqbx.service.TeacherService;
import com.yzk.hqbx.service.UserService;

@Controller
@RequestMapping("/teacher")
public class TeacherControl {
//	@Autowired
//	private StudentService studentService;
//	@Autowired
//	private UserService userService;
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/list")
	public String login(Model model) {
		model.addAttribute("list", teacherService.findall());
		return "teacherlist";
	}

	@RequestMapping("/del")
	public String del(Model model, int id) {
		teacherService.del(id);
		model.addAttribute("list", teacherService.findall());
		return "teacherlist";
	}

	@RequestMapping("/getbyid")
	public String getbyid(Model model, int id) {
		model.addAttribute("teacher", teacherService.getbyid(id));
		return "upTeacher";
	}
}
