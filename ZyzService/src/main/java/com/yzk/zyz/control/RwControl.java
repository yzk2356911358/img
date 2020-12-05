package com.yzk.zyz.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.zyz.model.Rw;
import com.yzk.zyz.service.RwService;

@Controller
public class RwControl {
	@Autowired
	private RwService rwService;

	@RequestMapping(value = "addrw")
	public String addrw(HttpSession httpSession, Model model, int zid, String fwlx, String date) {
		int sid = (int) httpSession.getAttribute("sid");
		if (httpSession.getAttribute("sid") == null) {
			return "login";
		}
		Rw rw = new Rw();
		rw.setDate(date);
		rw.setZid(zid);
		rw.setFwlx(fwlx);
		rw.setZt("1");
		rw.setSid(sid);
		rwService.add(rw);
		List<Rw> list = new ArrayList<>();
		for (Rw temp : rwService.findall()) {
			if (temp.getSid() == sid && temp.getZt().equals("已选择")) {
				list.add(temp);
			}
		}
		model.addAttribute("list", list);
		return "syzzzfwlist";
	}

	@RequestMapping(value = "zzfw")
	public String zzfw(HttpSession httpSession, Model model) {
		int sid = (int) httpSession.getAttribute("sid");
		if (httpSession.getAttribute("sid") == null) {
			return "login";
		}

		List<Rw> list = new ArrayList<>();
		for (Rw temp : rwService.findall()) {
			if (temp.getSid() == sid && temp.getZt().equals("已选择")||temp.getSid() == sid && temp.getZt().equals("1")||temp.getSid() == sid && temp.getZt().equals("正在服务")) {
				list.add(temp);
			}
		}
		model.addAttribute("list", list);
		return "syzzzfwlist";
	}

	@RequestMapping(value = "syzrwpjlist")
	public String syzrwpjlist(HttpSession httpSession, Model model) {
		int sid = (int) httpSession.getAttribute("sid");
		if (httpSession.getAttribute("sid") == null) {
			return "login";
		}

		List<Rw> list = new ArrayList<>();
		for (Rw temp : rwService.findall()) {
			if (temp.getSid() == sid && temp.getZt().equals("服务完成")) {
				list.add(temp);
			}
		}
		model.addAttribute("list", list);
		return "syzpjlist";
	}
	@RequestMapping(value = "syzrwpj")
	public String syzrwpj(HttpSession httpSession, Model model,String pj,int id) {
		int sid = (int) httpSession.getAttribute("sid");
		if (httpSession.getAttribute("sid") == null) {
			return "login";
		}
		Rw rw = rwService.getbyid(id);
		rw.setPj(pj);
		rw.setZt("已评价");
		rwService.up(rw);
		List<Rw> list = new ArrayList<>();
		for (Rw temp : rwService.findall()) {
			if (temp.getSid() == sid && temp.getZt().equals("服务完成")) {
				list.add(temp);
			}
		}
		model.addAttribute("list", list);
		return "syzpjlist";
	}
}
