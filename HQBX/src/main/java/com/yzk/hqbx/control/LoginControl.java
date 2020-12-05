package com.yzk.hqbx.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.hqbx.model.Czy;
import com.yzk.hqbx.model.User;
import com.yzk.hqbx.service.CzyService;
import com.yzk.hqbx.service.UserService;

@Controller
@RequestMapping("/")
public class LoginControl {
	@Autowired
	private UserService userservice;
	@Autowired
	private CzyService czyService;

//	@Autowired
//	private UserService userservice;
	@RequestMapping("login")
	public String login(Model model, User user, String type) {
		System.out.println(type);
		if (type.equals("g")) {
			for (User temp : userservice.findall()) {
				if (temp.getUsername().equals(user.getUsername()) && temp.getPassword().equals(user.getPassword())) {
					return "ggindex";
				}
			}
			model.addAttribute("error", "用户名或密码错误");
		}
		if (type.equals("c")) {
			for (Czy temp : czyService.findall()) {
				if (temp.getUsername().equals(user.getUsername()) && temp.getPassword().equals(user.getPassword())) {
					return "czyindex";
				}
			}
			model.addAttribute("error", "用户名或密码错误");
		}
		return "login";
	}
}
