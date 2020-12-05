package com.yzk.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.dao.AdminDao;
import com.yzk.dao.ShopDao;
import com.yzk.dao.UserDao;
import com.yzk.model.Admin;
import com.yzk.model.User;

@Controller
@RequestMapping("/")
public class LoginControl {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ShopDao shopdao;

	@RequestMapping("login")
	public String addshop(Model model, HttpSession httpSession, String type,String username,String password) {
		System.out.println(userDao.findall());
		System.out.println(adminDao.findall());
		if (type.equals("u")) {
			for (User temp : userDao.findall()) {
				if (temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
					model.addAttribute("list", shopdao.findall());
					httpSession.setAttribute("uname",password);
					return "index";
				}
			}
		} else {
			for (Admin temp : adminDao.findall()) {
				if (temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
					model.addAttribute("list", shopdao.findall());
					return "adminindex";
				}
			}
		}
		model.addAttribute("error", "用户名或密码错误");
		return "login";
	}

	@RequestMapping("reg")
	public String reg(Model model, HttpSession httpSession, String type, User user) {
		userDao.add(user);
		return "login";
	}

}
