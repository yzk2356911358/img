package com.yzk.hqbx.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.hqbx.model.User;
import com.yzk.hqbx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControl {
	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String login(Model model) {
		model.addAttribute("list", userService.findall());
		return "list_user";
	}
	
	@RequestMapping("/del")
	public String login(Model model,int id) {
		userService.del(id);
		model.addAttribute("list", userService.findall());
		return "list_user";
	}
	@RequestMapping("/get")
	public String get(Model model,int id) {
		model.addAttribute("user", userService.getbyid(id));
		return "up_user";
	}
	@RequestMapping("/up")
	public String up(Model model,User user) {
		userService.up(user);
		model.addAttribute("list", userService.findall());
		return "list_user";
	}
}
