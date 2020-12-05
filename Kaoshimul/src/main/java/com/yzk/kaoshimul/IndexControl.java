package com.yzk.kaoshimul;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yzk.kaoshimul.dao.MuluDao;
import com.yzk.kaoshimul.model.Mulu;

@Controller
@RequestMapping
public class IndexControl {
	@Autowired
	private MuluDao muludao;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("list", muludao.findAll());
		return "index";// 返回到HTML页面
	}

	@RequestMapping(value = "/fenlei", method = RequestMethod.GET)
	public String fenlei(Model model, String fenlei) {
		ArrayList<Mulu> mulus = new ArrayList<Mulu>();
		for (Mulu temp : muludao.findAll()) {
			if (temp.getFenlei().equals(fenlei)) {
				mulus.add(temp);
			}
		}
		model.addAttribute("list", mulus);
		return "index";// 返回到HTML页面
	}
}
