package com.yzk.personnel.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yzk.personnel.model.User;
import com.yzk.personnel.service.UserService;

@Controller
@RequestMapping
public class UserControl {
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String index() {
		return "login";// 返回到HTML页面
	}
	@RequestMapping(value = "/index")
	public String adminindex() {
		return "index";// 返回到HTML页面
	}
	@RequestMapping(value = "/NewFile")
	public String NewFile() {
		return "NewFile";// 返回到HTML页面
	}

	@RequestMapping(value = "/login")
	public String login(String username, String password) {
		for (User user : userservice.findall()) {
			if (user.getName().equals(username) && user.getPassword().equals(password)) {
				if (user.getRole() == 1) {
					return "adminindex";
				}
				return "userindex";
			}
		}
		
		return "login";//
	}
}
