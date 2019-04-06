package com.how2java.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.how2java.service.UploadService;
import com.how2java.utils.ReadExcel;

@Controller
public class UploadExcelController {
	
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping("uploadExcel")
	@ResponseBody
	public String updloadExcel(@RequestParam MultipartFile file,
					HttpServletRequest request, HttpServletResponse response) {
		String uploadExcel = uploadService.uploadExcel(file);
		
		
		return uploadExcel;
	}
}
