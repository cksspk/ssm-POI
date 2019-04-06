package com.how2java.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	String uploadExcel(MultipartFile file);
}
