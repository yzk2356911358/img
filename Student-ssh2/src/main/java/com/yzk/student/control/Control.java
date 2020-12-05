package com.yzk.student.control;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yzk.student.dao.BanjiDao;
import com.yzk.student.dao.ChengjiDao;
import com.yzk.student.dao.KcbxxDao;
import com.yzk.student.dao.KechengxxDao;
import com.yzk.student.dao.StudentDao;
import com.yzk.student.dao.UserDao;
import com.yzk.student.model.Banji;
import com.yzk.student.model.Chengji;
import com.yzk.student.model.Kcbxx;
import com.yzk.student.model.Kechengxx;
import com.yzk.student.model.Student;
import com.yzk.student.model.User;

@Controller
@RequestMapping("/")
public class Control {
	@Autowired
	private UserDao userdao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private BanjiDao banjiDao;
	@Autowired
	private KechengxxDao kechengxxDao;
	@Autowired
	private KcbxxDao kcbxxDao;
	@Autowired
	private ChengjiDao chengjiDao;

	@RequestMapping(value = "/login") // , method = RequestMethod.GET
	public String ProgramList(Model model, HttpSession httpSession) {
		return "login";// 返回到HTML页面
	}

	@RequestMapping(value = "/adminlogin") // , method = RequestMethod.GET
	public String adminlogin(Model model, User user) {
		System.out.println(user);
		for (User temp : userdao.findAll()) {
			if (temp.getUsername().equals(user.getUsername()) & temp.getPassword().equals(user.getPassword())) {
				return "adminindex";
			}
		}
		return "login";// 返回到HTML页面
	}

	@RequestMapping(value = "/studentlogin") // , method = RequestMethod.GET
	public String studentlogin(Model model, User user, HttpSession httpSession) {
		System.out.println(user);
		for (Student temp : studentDao.findAll()) {
			if (temp.getName().equals(user.getUsername()) & temp.getPassword().equals(user.getPassword())) {
				httpSession.setAttribute("student", temp);
				return "studentindex";
			}
		}
		return "studentlogin";// 返回到HTML页面
	}

	@RequestMapping(value = "/loginpage") // , method = RequestMethod.GET
	public String loginpage(Model model, HttpSession httpSession) {
		return "login";// 返回到HTML页面
	}

	@RequestMapping(value = "/userlist") // , method = RequestMethod.GET
	public String userlist(Model model, HttpSession httpSession) {
		model.addAttribute("list", userdao.findAll());
		return "userlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/adduser") // , method = RequestMethod.GET
	public String adduser(Model model, User user, HttpSession httpSession) {
		userdao.save(user);
		model.addAttribute("list", userdao.findAll());
		return "userlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/userdel") // , method = RequestMethod.GET
	public String userdel(Model model, int id) {
		userdao.delete(userdao.getOne(id));
		model.addAttribute("list", userdao.findAll());
		return "userlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/studentdel") // , method = RequestMethod.GET
	public String studentdel(Model model, int id) {
		studentDao.delete(studentDao.getOne(id));
		model.addAttribute("list", studentDao.findAll());
		return "studentlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/getstudentmessage") // , method = RequestMethod.GET
	public String studentdel(Model model, HttpSession httpSession) {
		ArrayList<Student> list = new ArrayList<Student>();
		Student student = (Student) httpSession.getAttribute("student");
		list.add(student);
		model.addAttribute("list", list);
		return "studentlistmessage";// 返回到HTML页面
	}

	@RequestMapping(value = "/banjidel") // , method = RequestMethod.GET
	public String banjidel(Model model, int id) {
		banjiDao.delete(banjiDao.getOne(id));
		model.addAttribute("list", banjiDao.findAll());
		return "banjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/studentlist") // , method = RequestMethod.GET
	public String studentlist(Model model) {
		model.addAttribute("list", studentDao.findAll());
		return "studentlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/addstudent") // , method = RequestMethod.GET
	public String addstudent(Model model, Student student) {
		studentDao.save(student);
		model.addAttribute("list", studentDao.findAll());
		return "studentlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/banjilist") // , method = RequestMethod.GET
	public String banjilist(Model model) {
		model.addAttribute("list", banjiDao.findAll());
		return "banjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/getbanjimessage") // , method = RequestMethod.GET
	public String getbanjimessage(Model model, HttpSession httpSession) {
		Student student = (Student) httpSession.getAttribute("student");
		System.out.println(student);
		ArrayList<Banji> arrayList = new ArrayList<Banji>();
		for (Banji banji : banjiDao.findAll()) {
			if (banji.getName().equals(student.getBj())) {
				arrayList.add(banji);
			}
		}
		model.addAttribute("list", arrayList);
		return "banjilistmessage";// 返回到HTML页面
	}

	@RequestMapping(value = "/addbanji") // , method = RequestMethod.GET
	public String addbanji(Model model, Banji banji) {
		banjiDao.save(banji);
		model.addAttribute("list", banjiDao.findAll());
		return "banjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/kechenglist") // , method = RequestMethod.GET
	public String Kcblist(Model model) {
		model.addAttribute("list", kechengxxDao.findAll());
		return "kechenglist";// 返回到HTML页面
	}

	@RequestMapping(value = "/addkechngb") // , method = RequestMethod.GET
	public String addkechngb(Model model, Kechengxx kechengxx) {
		kechengxxDao.save(kechengxx);
		model.addAttribute("list", kechengxxDao.findAll());
		return "kechenglist";// 返回到HTML页面
	}

	@RequestMapping(value = "/kechengdel") // , method = RequestMethod.GET
	public String kechengdel(Model model, int id) {
		kechengxxDao.delete(kechengxxDao.getOne(id));
		model.addAttribute("list", kechengxxDao.findAll());
		return "kechenglist";// 返回到HTML页面
	}

	@RequestMapping(value = "/kechengxxlist") // , method = RequestMethod.GET
	public String kechengxxlist(Model model) {
		model.addAttribute("list", kcbxxDao.findAll());
		return "kechengxxlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/kechengxxlistmessage") // , method = RequestMethod.GET
	public String kechengxxlistmessage(Model model) {
		model.addAttribute("list", kcbxxDao.findAll());
		return "kechengxxlistmessage";// 返回到HTML页面
	}

	@RequestMapping(value = "/kechenglistmessage") // , method = RequestMethod.GET
	public String kechenglistmessage(Model model) {
		model.addAttribute("list", kechengxxDao.findAll());
		return "kechenglistmessage";// 返回到HTML页面
	}

	@RequestMapping(value = "/addkechngbxx") // , method = RequestMethod.GET
	public String addkechngbxx(Model model, Kcbxx kcbxx) {
		kcbxxDao.save(kcbxx);
		model.addAttribute("list", kcbxxDao.findAll());
		return "kechengxxlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/chegnjilist") // , method = RequestMethod.GET
	public String chegnjilist(Model model) {
		model.addAttribute("list", chengjiDao.findAll());
		return "chegnjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/chengjilistmessage") // , method = RequestMethod.GET
	public String chengjilistmessage(Model model, HttpSession httpSession) {
		Student student = (Student) httpSession.getAttribute("student");
		ArrayList<Chengji> arrayList = new ArrayList<Chengji>();
		for (Chengji temp : chengjiDao.findAll()) {
			if (temp.getXh() == student.getId()) {
				arrayList.add(temp);
			}
		}
		model.addAttribute("list", arrayList);
		return "chegnjilistmessage";// 返回到HTML页面
	}

	@RequestMapping(value = "/addchegnji") // , method = RequestMethod.GET
	public String addchegnji(Model model, Chengji chengji) {
		chengjiDao.save(chengji);
		model.addAttribute("list", chengjiDao.findAll());
		return "chegnjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/kechengxxdel") // , method = RequestMethod.GET
	public String kechengxxdel(Model model, int id) {
		kcbxxDao.delete(kcbxxDao.getOne(id));
		model.addAttribute("list", kcbxxDao.findAll());
		return "kechengxxlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/chegnjidel") // , method = RequestMethod.GET
	public String chegnjidel(Model model, int id) {
		chengjiDao.delete(chengjiDao.getOne(id));
		model.addAttribute("list", chengjiDao.findAll());
		return "chegnjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/select") // , method = RequestMethod.GET
	public String select(Model model, String name, String type) {
		if (type.equals("user")) {
			ArrayList<User> users = new ArrayList<User>();
			for (User user : userdao.findAll()) {
				if (user.getUsername().equals(name)) {
					users.add(user);
				}
			}
			model.addAttribute("list", users);
			return "userlist";// 返回到HTML页面
		}
		if (type.equals("student")) {
			ArrayList<Student> temps = new ArrayList<Student>();
			for (Student temp : studentDao.findAll()) {
				if (temp.getName().equals(name)) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "studentlist";// 返回到HTML页面
		}
		if (type.equals("banji")) {
			ArrayList<Banji> temps = new ArrayList<Banji>();
			for (Banji temp : banjiDao.findAll()) {
				if (temp.getName().equals(name)) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "banjilist";// 返回到HTML页面
		}
		if (type.equals("banji")) {
			ArrayList<Banji> temps = new ArrayList<Banji>();
			for (Banji temp : banjiDao.findAll()) {
				if (temp.getName().equals(name)) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "banjilist";// 返回到HTML页面
		}
		if (type.equals("kcb")) {
			ArrayList<Kechengxx> temps = new ArrayList<Kechengxx>();
			for (Kechengxx temp : kechengxxDao.findAll()) {
				if (temp.getName().equals(name)) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "kechenglist";// 返回到HTML页面
		}
		if (type.equals("kcb")) {
			ArrayList<Kechengxx> temps = new ArrayList<Kechengxx>();
			for (Kechengxx temp : kechengxxDao.findAll()) {
				if (temp.getName().equals(name)) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "kechenglist";// 返回到HTML页面
		}

		if (type.equals("kcbxx")) {
			ArrayList<Kcbxx> temps = new ArrayList<Kcbxx>();
			for (Kcbxx temp : kcbxxDao.findAll()) {
				if (temp.getKcname().equals(name)) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "kechengxxlist";// 返回到HTML页面
		}
		if (type.equals("cj")) {
			ArrayList<Chengji> temps = new ArrayList<Chengji>();
			for (Chengji temp : chengjiDao.findAll()) {
				int xh = Integer.parseInt(name);
				if (temp.getXh() == xh) {
					temps.add(temp);
				}
			}
			model.addAttribute("list", temps);
			return "chegnjilist";// 返回到HTML页面
		}
		return "chegnjilist";// 返回到HTML页面
	}

	@RequestMapping(value = "/upuser") // , method = RequestMethod.GET
	public String upuser(Model model, User user) {
		User user2 = userdao.getOne(user.getId());
		user2 = user;
		userdao.save(user2);
		model.addAttribute("list", userdao.findAll());
		return "userlist";// 返回到HTML页面
	}

	@RequestMapping(value = "/get") // , method = RequestMethod.GET
	public String get(Model model, int id, String type) {
		if (type.equals("user")) {
			for (User user : userdao.findAll()) {
				if (user.getId() == id) {
					model.addAttribute("temp", user);
					return "upuser";// 返回到HTML页面
				}
			}

		}
		if (type.equals("student")) {
			for (Student temp : studentDao.findAll()) {
				if (temp.getId() == id) {
					model.addAttribute("temp", temp);
					return "upstudent";// 返回到HTML页面
				}
			}

		}
		if (type.equals("banji")) {
			for (Banji temp : banjiDao.findAll()) {
				if (temp.getId() == id) {
					model.addAttribute("temp", temp);
					return "upbanji";// 返回到HTML页面
				}
			}

		}

		if (type.equals("kcb")) {
			for (Kechengxx temp : kechengxxDao.findAll()) {
				if (temp.getId() == id) {
					model.addAttribute("temp", temp);
					return "upkechngb";// 返回到HTML页面
				}
			}

		}

		if (type.equals("kcbxx")) {
			for (Kcbxx temp : kcbxxDao.findAll()) {
				if (temp.getId() == id) {
					model.addAttribute("temp", temp);
					return "upkechngbxx";// 返回到HTML页面
				}
			}

		}
		if (type.equals("cj")) {
			for (Chengji temp : chengjiDao.findAll()) {
				if (temp.getId() == id) {
					model.addAttribute("temp", temp);
					return "upchengji";// 返回到HTML页面
				}
			}
		}
		return "chegnjilist";// 返回到HTML页面
	}

}
