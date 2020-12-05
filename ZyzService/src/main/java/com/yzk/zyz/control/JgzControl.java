package com.yzk.zyz.control;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.zyz.model.Jgz;
import com.yzk.zyz.model.Rw;
import com.yzk.zyz.model.Syz;
import com.yzk.zyz.service.JgzService;
import com.yzk.zyz.service.RwService;
import com.yzk.zyz.service.SyzService;

@Controller
public class JgzControl {
	@Autowired
	private RwService rwService;
	@Autowired
	private JgzService jgzService;
	@Autowired
	private SyzService syszService;

	@RequestMapping(value = "jgzgetrw")
	public String zyzmessage(HttpSession httpSession, Model model) {
		int jid = (int) httpSession.getAttribute("jid");
		if (httpSession.getAttribute("jid") == null) {
			return "login";
		}
		if (jgzService.getByid(jid).getSyzid() == 0) {
			return "syszfwqk";
		}
		ArrayList<Rw> list = new ArrayList<>();
		for (Rw rw : rwService.findall()) {
			if (jgzService.getByid(jid).getSyzid() == rw.getSid()) {
				list.add(rw);
			}
		}
		model.addAttribute("list", list);
		return "syszfwqk";
	}

	@RequestMapping(value = "jgzaddsyz")
	public String jgzaddsyz(HttpSession httpSession, Model model, Syz syz) {
		System.out.println(syz);
		int jid = (int) httpSession.getAttribute("jid");
		if (httpSession.getAttribute("jid") == null) {
			return "login";
		}
		syszService.add(syz);
		Jgz jgz = jgzService.getByid(jid);
		Syz temp = syszService.getByname(syz.getName());
		jgz.setSyzid(temp.getId());
		jgzService.up(jgz);
		ArrayList<Rw> list = new ArrayList<>();
		for (Rw rw : rwService.findall()) {
			if (jgzService.getByid(jid).getSyzid() == rw.getSid()) {
				list.add(rw);
			}
		}
		model.addAttribute("list", list);
		return "syszfwqk";
	}
}
