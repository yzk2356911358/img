package com.yzk.shsystem.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yzk.shsystem.dao.ProgramDao;
import com.yzk.shsystem.model.Program;
import com.yzk.shsystem.util.FileUtils;

@Controller
@RequestMapping("/")
public class ProgramControl {
	@Autowired
	private ProgramDao programdao;

	@RequestMapping("/addprogram")
	@ResponseBody
	public String addprogram(@RequestParam("uploadFiles") MultipartFile[] files, Program program, Model model) {
		List<Map<String, Object>> root = new ArrayList<Map<String, Object>>();
		int i = 0;
		for (MultipartFile file : files) { // 循环保存文件
			i++;
			Map<String, Object> result = new HashMap<String, Object>();// 一个文件上传的结果
			String result_msg = "";// 上传结果信息
			String fileType = file.getContentType();
			if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
				final String localPath = System.getProperty("user.dir");
				String fileName = file.getOriginalFilename();
				String suffixName = fileName.substring(fileName.lastIndexOf("."));
				fileName = UUID.randomUUID() + suffixName;
				if (i == 1) {
					program.setInfoimg1(fileName);
				}
				if (i == 2) {
					program.setInfoimg2(fileName);
				}
				if (i == 3) {
					program.setInfoimg3(fileName);
				}
				if (i == 4) {
					program.setInfoimg4(fileName);
				}
				if (i == 5) {
					program.setInfoimg5(fileName);
				}
				if (i == 6) {
					program.setInfoimg6(fileName);
				}
				if (i == 7) {
					program.setInfoimg7(fileName);
				}
				if (i == 8) {
					program.setInfoimg8(fileName);
				}
				if (FileUtils.upload(file, localPath, fileName)) {
					System.out.println("localPath:" + localPath);
					String relativePath = "img/" + fileName;
					result.put("relativePath", relativePath);// 前端根据是否存在该字段来判断上传是否成功
					result_msg = "图片上传成功";
				} else {
					result_msg = "图片上传失败";
				}
			} else {
				result_msg = "图片格式不正确";
			}
			result.put("result_msg", result_msg);
			root.add(result);
		}
		if (files.length == 0) {
			model.addAttribute("list", programdao.findAll());
			return "ProgramList";
		}
		programdao.save(program);
		model.addAttribute("list", programdao.findAll());
		return "添加成功";
	}

	@RequestMapping(value = "/ProgramList") // , method = RequestMethod.GET
	public String ProgramList(Model model, HttpSession httpSession) {
		Pageable pageable = PageRequest.of(0, 2);//
		System.out.println(programdao.findAll().size());
		Page<Program> page1 = this.programdao.findAll(pageable);
//		System.out.println("总条数：" + page1.getTotalElements());
//		System.out.println("总页数：" + page1.getTotalPages());
		model.addAttribute("list", page1.getContent());
		model.addAttribute("page", 1);
		return "ProgramList";// 返回到HTML页面
	}

	@RequestMapping(value = "/ProgramListpage") // , method = RequestMethod.GET
	public String ProgramListpage(Model model, HttpSession httpSession, int page, int lx) {
		Page<Program> page1 = null;
		Pageable pageablesum = PageRequest.of(0, 2);//
		Page<Program> pagesum = this.programdao.findAll(pageablesum);
		if (page == 1 && lx == 1) {
			Pageable pageable = PageRequest.of(0, 2);//
			page1 = this.programdao.findAll(pageable);
			model.addAttribute("list", page1.getContent());
			model.addAttribute("page", 1);
			return "ProgramList";// 返回到HTML页面
		} else if (page == 1 && lx == 2) {
			Pageable pageable = PageRequest.of(page, 2);//
			page1 = this.programdao.findAll(pageable);
			model.addAttribute("list", page1.getContent());
			model.addAttribute("page", page + 1);
			return "ProgramList";// 返回到HTML页面
		}
		if (page == pagesum.getTotalPages() && lx == 2) {
			Pageable pageable = PageRequest.of(page - 1, 2);//
			page1 = this.programdao.findAll(pageable);
			model.addAttribute("list", page1.getContent());
			model.addAttribute("page", page);
			return "ProgramList";// 返回到HTML页面
		}
		if (lx == 1) {
			Pageable pageable = PageRequest.of(page - 2, 2);//
			page1 = this.programdao.findAll(pageable);
			model.addAttribute("list", page1.getContent());
			model.addAttribute("page", page - 1);
			return "ProgramList";// 返回到HTML页面
		}
		if (lx == 2) {
			Pageable pageable = PageRequest.of(page, 2);//
			page1 = this.programdao.findAll(pageable);
			model.addAttribute("list", page1.getContent());
			model.addAttribute("page", page + 1);
			return "ProgramList";// 返回到HTML页面
		}

		model.addAttribute("list", page1.getContent());
		model.addAttribute("page", page + 1);
		return "ProgramList";// 返回到HTML页面
	}

	@RequestMapping(value = "/Programdel") // , method = RequestMethod.GET
	public String Programdel(Model model, int id) {
		Program program = programdao.getOne(id);
		programdao.delete(program);
		FileUtils.DeleteFolder(program.getInfoimg1());
		FileUtils.DeleteFolder(program.getInfoimg2());
		FileUtils.DeleteFolder(program.getInfoimg3());
		FileUtils.DeleteFolder(program.getInfoimg4());
		FileUtils.DeleteFolder(program.getInfoimg5());
		FileUtils.DeleteFolder(program.getInfoimg6());
		FileUtils.DeleteFolder(program.getInfoimg7());
		FileUtils.DeleteFolder(program.getInfoimg8());
		Page<Program> page1 = null;
		Pageable pageable = PageRequest.of(0, 2);//
		page1 = this.programdao.findAll(pageable);
		model.addAttribute("list", page1.getContent());
		model.addAttribute("page", 1);
		return "ProgramList";// 返回到HTML页面
	}

	@RequestMapping(value = "/adminindex") // , method = RequestMethod.GET
	public String adminindex(Model model) {
		return "adminindex";// 返回到HTML页面
	}

	@RequestMapping(value = "/index") // , method = RequestMethod.GET
	public String index(Model model) {
		model.addAttribute("list", programdao.findAll());
		return "index";// 返回到HTML页面
	}
}
