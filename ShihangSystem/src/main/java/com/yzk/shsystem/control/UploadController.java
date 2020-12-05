//package com.yzk.shsystem.control;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//public class UploadController {
//	// private static String filePath="C:/Users/Administrator/Desktop/";
//	// 默认注入application.properties里的对应值
//	@Value("${web.upload-path}")
//	private String filePath;
//
//	@RequestMapping(value = "upload")
//	@ResponseBody
//	public void upload(@RequestParam("uploadFile") MultipartFile file, HttpServletRequest request) {
//
//		// file.isEmpty(); 判断图片是否为空
//		// file.getSize(); 图片大小进行判断
//		// 获取文件名
//		String fileName = file.getOriginalFilename();
//		System.out.println("上传的文件名为：" + fileName);
//		// 获取文件的后缀名,比如图片的jpeg,png
//		String suffixName = fileName.substring(fileName.lastIndexOf("."));
//		System.out.println("上传的后缀名为：" + suffixName);
//		// 文件上传后的路径
//		fileName = UUID.randomUUID() + suffixName;
//		System.out.println("转换后的名称:" + fileName);
//		File dest = new File(System.getProperty("user.dir")+"\\file\\" + fileName);
//		// 文件上传路径
//		System.out.println("filepath:" + filePath);
//		// 文件路径
//		System.out.println("dest:" + dest);
//		try {
//			// 存储文件
//			file.transferTo(dest);
//			// 返回访问路径
//			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/"
//					+ fileName;
//			System.out.println("url:" + url);
//			// 返回成功结果
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//
//		}
//		// 返回失败结果
//	}
//
//}
