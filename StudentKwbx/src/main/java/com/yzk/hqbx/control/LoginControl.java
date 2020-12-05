package com.yzk.hqbx.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.hqbx.model.User;
import com.yzk.hqbx.service.StudentService;
import com.yzk.hqbx.service.UserService;

@Controller
@RequestMapping("/")
public class LoginControl {
//	@Autowired
//	private StudentService studentService;
	@Autowired
	private UserService userService;

	@RequestMapping("login")
	public String login(Model model, String username, String password, String type) {
		if (type.equals("s")) {
			System.out.println("學生登录");
		}
		if (type.equals("t")) {
			System.out.println("教师登录");
		}
		if (type.equals("g")) {
			for (User user : userService.findall()) {
				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					return "adminindex";
				}
			}
		}
		model.addAttribute("error", "用户名或密码错误！");
		return "login";
	}
}
