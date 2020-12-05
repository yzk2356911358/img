package com.yzk.hqbx.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.hqbx.service.CzyService;

@Controller
@RequestMapping("/admin")
public class AdminControl {
	@Autowired
	private CzyService czyService;

	@RequestMapping("/index")
	public String login() {
		return "adminindex";
	}
}
