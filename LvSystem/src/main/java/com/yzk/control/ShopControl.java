package com.yzk.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yzk.dao.ShopDao;
import com.yzk.file.Fileupdate;
import com.yzk.model.Shop;

@Controller
@RequestMapping("/")
public class ShopControl {
	@Autowired
	private ShopDao shopdao;

	@RequestMapping("add")
	public String addshop(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request,
			String title, Double moneya) {

		Fileupdate fileupdate = new Fileupdate();
		fileupdate.fileupdate(file);
		Shop shop = new Shop();
		shop.setImg(file.getOriginalFilename());
		shop.setMoney(moneya);
		shop.setTitle(title);
		shopdao.add(shop);
		model.addAttribute("list", shopdao.findall());
		return "adminlylist";
	}

	@RequestMapping("uplv")
	public String uplv(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request, String title,
			Double moneya, int id) {
		Shop shop = shopdao.getbyid(id);
		System.out.println(shop);
		if (file != null) {
			Fileupdate fileupdate = new Fileupdate();
			fileupdate.fileupdate(file);
			shop.setImg(file.getOriginalFilename());
		}
		shop.setMoney(moneya);
		shop.setTitle(title);
		shopdao.up(shop);
		System.out.println(shop);
		model.addAttribute("list", shopdao.findall());
		return "adminlylist";
	}

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("list", shopdao.findall());
		return "index";
	}

	@RequestMapping("getlv")
	public String getlv(Model model, int id) {
		model.addAttribute("shop", shopdao.getbyid(id));
		return "uplv";
	}

	@RequestMapping("admingetlylist")
	public String admingetlylist(Model model) {
		model.addAttribute("list", shopdao.findall());
		return "adminlylist";
	}

	@RequestMapping("dellv")
	public String dellv(Model model, int id) {
		shopdao.del(id);
		model.addAttribute("list", shopdao.findall());
		return "adminlylist";
	}
}
