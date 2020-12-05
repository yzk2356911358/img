package com.yzk.hqbx.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.hqbx.model.Czy;
import com.yzk.hqbx.model.User;
import com.yzk.hqbx.service.CzyService;

@Controller
@RequestMapping("/czy")
public class CzyControl {
	@Autowired
	private CzyService czyService;


	@RequestMapping("/list")
	public String login(Model model) {
		model.addAttribute("list", czyService.findall());
		return "list_czy";
	}
	
	@RequestMapping("/del")
	public String login(Model model,int id) {
		czyService.del(id);
		model.addAttribute("list", czyService.findall());
		return "list_czy";
	}
	@RequestMapping("/get")
	public String get(Model model,int id) {
		model.addAttribute("user", czyService.getbyid(id));
		return "up_czy";
	}
	@RequestMapping("/up")
	public String up(Model model,Czy czy) {
		czyService.up(czy);
		model.addAttribute("list", czyService.findall());
		return "list_czy";
	}
}
