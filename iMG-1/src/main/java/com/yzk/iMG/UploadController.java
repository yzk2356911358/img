package com.yzk.iMG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-15 14:04
 */
@Controller
public class UploadController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}

	@PostMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,String lr) {
		if (file.isEmpty()) {
			return "上传失败，请选择文件";
		}

		String fileName = file.getOriginalFilename();
		String filePath = "D://img//";
		File dest = new File(filePath + fileName);
		try {
			file.transferTo(dest);
			LOGGER.info("上传成功");
			Font font = new Font("宋体", Font.PLAIN, 20); // 水印字体
			String srcImgPath = "D://img//" + fileName; // 源图片地址
			String tarImgPath = "D://img//" + "s" + fileName; // 待存储的地址
//    		Color color = Color.GRAY; // 水印图片色彩以及透明度
			Color color = new Color(107, 109, 106);
			new WaterMarkUtils().addWaterMark(srcImgPath, tarImgPath, lr, color, font, -40);
			return "上传成功";
		} catch (IOException e) {
			LOGGER.error(e.toString(), e);
		}
		return "上传失败！";
	}

}
