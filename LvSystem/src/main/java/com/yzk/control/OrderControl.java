package com.yzk.control;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.dao.OrderDao;
import com.yzk.model.Order;

@Controller
@RequestMapping("/")
public class OrderControl {
	@Autowired
	private OrderDao orderDao;

	@RequestMapping("addorder")
	public String addorder(Model model, Order order, String hotelname, String money, HttpSession httpSession) {
		order.setName((String) httpSession.getAttribute("uname"));
		orderDao.add(order);
		ArrayList<Order> orders = new ArrayList<Order>();
		for (Order temp : orderDao.findall()) {
			if (temp.getName().equals(httpSession.getAttribute("uname"))) {
				orders.add(temp);
			}
		}
		model.addAttribute("list", orders);
		return "orderlist";
	}

	@RequestMapping("orderlist")
	public String orderlist(Model model, HttpSession httpSession) {
		ArrayList<Order> orders = new ArrayList<Order>();
		for (Order temp : orderDao.findall()) {
			if (temp.getName().equals(httpSession.getAttribute("uname"))) {
				orders.add(temp);
			}
		}
		model.addAttribute("list", orders);
		return "orderlist";
	}

	@RequestMapping("adminorderlist")
	public String adminorderlist(Model model, HttpSession httpSession) {
		model.addAttribute("list", orderDao.findall());
		return "adminorderlist";
	}
}
