package com.yzk.zyz.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.zyz.model.Jgz;
import com.yzk.zyz.model.Rw;
import com.yzk.zyz.model.Syz;
import com.yzk.zyz.model.Zyz;
import com.yzk.zyz.service.JgzService;
import com.yzk.zyz.service.RwService;
import com.yzk.zyz.service.SyzService;
import com.yzk.zyz.service.ZyzService;

@Controller
public class ZyzControl {
	@Autowired
	private ZyzService zyzService;
	@Autowired
	private RwService rwService;
	@Autowired
	private SyzService syzServicel;
	@Autowired
	private JgzService jgzService;

	@RequestMapping(value = "loginpage")
	public String loginpage() {
		return "login";

	}

	@RequestMapping(value = "zyzmessage")
	public String zyzmessage(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("zid") == null) {
			return "login";
		}
		model.addAttribute("zyz", zyzService.getByid((int) httpSession.getAttribute("zid")));
		return "zyzmessage";
	}

	@RequestMapping(value = "getallzyz")
	public String getallzyz(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("sid") == null) {
			return "login";
		}
		System.out.println(zyzService.findall());
		model.addAttribute("list", zyzService.findall());
		return "syzaddrw";
	}

	@RequestMapping(value = "upzyzmessage")
	public String upzyzmessage(HttpSession httpSession, Model model, Zyz zyz) {
		if (httpSession.getAttribute("zid") == null) {
			return "login";
		}
		System.out.println(zyz);
		zyzService.up(zyz);
		model.addAttribute("zyz", zyzService.getByid((int) httpSession.getAttribute("zid")));
		return "zyzmessage";
	}

	@RequestMapping(value = "zyzwcqkhb")
	public String zyzwcqkhb(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("zid") == null) {
			return "login";
		}
		model.addAttribute("list", rwService.getByzid((int) httpSession.getAttribute("zid"), "正在服务"));
		return "zyzwcqkhb";
	}

	@RequestMapping(value = "tzrwpage")
	public String tzrwpage(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("zid") == null) {
			return "login";
		}
		model.addAttribute("list", rwService.getByzid((int) httpSession.getAttribute("zid"), "已选择"));
		return "zyztzlist";
	}

	@RequestMapping(value = "zyzuprwstatic")
	public String zyzuprwstatic(String zt, int id, String qwcqk, String hwcqk, HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("zid") == null) {
			return "login";
		}
		Rw rw = rwService.getbyid(id);
		if (qwcqk != null) {
			rw.setQwcqk(qwcqk);
		}
		if (hwcqk != null) {
			rw.setHwcqk(hwcqk);
		}
		rwService.up(rwService.getbyid(id), zt);
		model.addAttribute("list", rwService.getByzid((int) httpSession.getAttribute("zid"), "1"));
		return "zyzrwlist";
	}

	@RequestMapping(value = "zyzrwlist")
	public String zyzrwlist(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("zid") == null) {
			return "login";
		}
		model.addAttribute("list", rwService.getByzid((int) httpSession.getAttribute("zid"), "1"));
		return "zyzrwlist";
	}

	@RequestMapping(value = "login")
	public String login(String username, String password, String type, Model model, HttpSession httpSession) {
		System.out.println(type);
		if (type == null) {
			return "login";
		}
		if (type.equals("志愿者")) {
			Zyz zyz = zyzService.getByusername(username);
			if (zyz != null) {
				if (zyz.getUsername().equals(username) && zyz.getPassword().equals(password)) {
					httpSession.setAttribute("zid", zyz.getId());
					model.addAttribute("zyz", zyz);
					return "zyzindex";
				}
			}
		}
		if (type.equals("监管者")) {
			Jgz jgz = jgzService.getByname(username);
			if (jgz != null) {
				if (jgz.getName().equals(username) && jgz.getPassword().equals(password)) {
					httpSession.setAttribute("jid", jgz.getId());
					model.addAttribute("jgz", jgz);
					return "jgzindex";
				}
			}
		}
		if (type.equals("受益者")) {
			Syz syz = syzServicel.getByname(username);
			if (syz != null) {
				if (syz.getName().equals(username) && syz.getPassword().equals(password)) {
					httpSession.setAttribute("sid", syz.getId());
					model.addAttribute("syz", syz);
					return "syzindex";
				}
			}
		}
		model.addAttribute("error", "用户名或密码错误！");
		return "login";
	}

	@RequestMapping(value = "reg")
	public String reg(String username, String password, String type, Model model, HttpSession httpSession) {
		System.out.println(type);
		if (type == null) {
			return "reg.html";
		}
		if (type.equals("志愿者")) {
			Zyz zyz = new Zyz();
			zyz.setUsername(username);
			zyz.setPassword(password);
			zyz.setZzmm("1");
			zyzService.add(zyz);
		}
		if (type.equals("监管者")) {
			Jgz jgz = new Jgz();
			jgz.setName(username);
			jgz.setPassword(password);
			jgzService.add(jgz);
		}
		if (type.equals("受益者")) {
			Syz syz = new Syz();
			syz.setName(username);
			syz.setPassword(password);
			syzServicel.add(syz);
		}
		return "login";
	}
}
