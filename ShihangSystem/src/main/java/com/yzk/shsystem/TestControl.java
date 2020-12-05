//package com.yzk.shsystem;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//@RequestMapping("/")
//public class TestControl {
//
//	@RequestMapping(value = "/index") // , method = RequestMethod.GET
//	public String index() throws FileNotFoundException {
//		System.out.println(System.getProperty("user.dir"));
//		return "index";// 返回到HTML页面
//	}
//
////	@RequestMapping("/upload")
////	public String upload(@RequestParam("file") MultipartFile file) {
////		if (file.isEmpty()) {
////			return "上传失败，请选择文件";
////		}
////
////		String fileName = file.getOriginalFilename();
////		String filePath = System.getProperty("user.dir")+"\\file\\";
////		System.out.println(filePath);
////		File dest = new File(filePath + fileName);
////		try {
////			file.transferTo(dest);
////		} catch (IllegalStateException e) {
////			e.printStackTrace();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////
////		return "index";
////	}
//	@RequestMapping("/add")
//	public String multipleImageUpload(@RequestParam("uploadFiles") MultipartFile[] files) {
//		System.out.println("上传的图片数：" + files.length);
//		List<Map<String, Object>> root = new ArrayList<Map<String, Object>>();
//		for (MultipartFile file : files) { // 循环保存文件
//			Map<String, Object> result = new HashMap<String, Object>();// 一个文件上传的结果
//			String result_msg = "";// 上传结果信息
//			String fileType = file.getContentType();
//			if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
//				final String localPath = System.getProperty("user.dir") + "\\file\\";
//				String fileName = file.getOriginalFilename();
//				String suffixName = fileName.substring(fileName.lastIndexOf("."));
//				fileName = UUID.randomUUID() + suffixName;
//				if (FileUtils.upload(file, localPath, fileName)) {
//					String relativePath = "img/" + fileName;
//					result.put("relativePath", relativePath);// 前端根据是否存在该字段来判断上传是否成功
//					result_msg = "图片上传成功";
//				} else {
//					result_msg = "图片上传失败";
//				}
//			} else {
//				result_msg = "图片格式不正确";
//			}
//			result.put("result_msg", result_msg);
//			root.add(result);
//		}
//		return "index";
//	}
//
//}
