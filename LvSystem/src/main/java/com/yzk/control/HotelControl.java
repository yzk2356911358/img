package com.yzk.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yzk.dao.HotelDao;
import com.yzk.file.Fileupdate;
import com.yzk.model.Hotel;

@Controller
@RequestMapping("/")
public class HotelControl {
	@Autowired
	private HotelDao hotelDao;

	@RequestMapping("hoteladd")
	public String addshop(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request,
			String title, Double moneya) {
		
		Fileupdate fileupdate = new Fileupdate();
		fileupdate.fileupdate(file);
		Hotel hotel = new Hotel();
		hotel.setImg(file.getOriginalFilename());
		hotel.setMoney(moneya);
		hotel.setTitle(title);
		hotelDao.add(hotel);
		model.addAttribute("list", hotelDao.findall());
		return "adminhotellist";
	}

	@RequestMapping("uphotel")
	public String uphotel(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request,
			String title, Double moneya,int id) {
		
		Hotel hotel = hotelDao.getbyid(id);
		System.out.println(hotel);
		if (file.getOriginalFilename() == null||!file.getOriginalFilename().equals("")) {
			System.out.println("file等于空");
			Fileupdate fileupdate = new Fileupdate();
			fileupdate.fileupdate(file);
			hotel.setImg(file.getOriginalFilename());
		}
		System.out.println(hotel);
		hotel.setMoney(moneya);
		hotel.setTitle(title);
		hotelDao.up(hotel);
		model.addAttribute("list", hotelDao.findall());
		return "adminhotellist";
	}

	@RequestMapping("hotelindex")
	public String index(Model model) {
		model.addAttribute("list", hotelDao.findall());
		return "hotelindex";
	}
	@RequestMapping("gethotelmessage")
	public String gethotelmessage(Model model,int id) {
		model.addAttribute("hotel", hotelDao.getbyid(id));
		return "addhotelorder";
	}

	@RequestMapping("adminhotellist")
	public String adminhotellist(Model model) {
		model.addAttribute("list", hotelDao.findall());
		return "adminhotellist";
	}

	@RequestMapping("gethotel")
	public String gethotel(Model model, int id) {
		model.addAttribute("hotel", hotelDao.getbyid(id));
		return "uphotel";
	}

	@RequestMapping("delhotel")
	public String delhotel(Model model, int id) {
		hotelDao.del(id);
		model.addAttribute("list", hotelDao.findall());
		return "adminhotellist";
	}
}
