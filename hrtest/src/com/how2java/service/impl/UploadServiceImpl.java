package com.how2java.service.impl;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.how2java.mapper.EmployeeMapper;
import com.how2java.pojo.Employee;
import com.how2java.service.UploadService;
import com.how2java.utils.ReadExcel;

@Service("UploadService")
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public String uploadExcel(MultipartFile file) {
		//获取文件名
		String fileName = file.getOriginalFilename();
		//文件流
		InputStream in = null;
		List<List<Object>> listob = null;
		try {
			in = file.getInputStream();
			//处理Excel
			listob = new ReadExcel().getBankListByExcel(in, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	    //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
        for (int i = 0; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            Employee employee = new Employee(); 
            
            System.out.println(lo);
            
            employee.setStrName(String.valueOf(lo.get(0))); 
            employee.setStrDepartment(String.valueOf(lo.get(1))); 
            employee.setStrStation(String.valueOf(lo.get(2))); 
            employee.setStrPhoneNum(String.valueOf(lo.get(3))); 
            employee.setStrUniversity(String.valueOf(lo.get(4))); 
            employee.setStrMajor(String.valueOf(lo.get(5))); 
            employee.setStrEducation(String.valueOf(lo.get(6))); 
            employee.setStrGraduationTime(String.valueOf(lo.get(7))); 
            employee.setStrEntryTime(String.valueOf(lo.get(8))); 
            employee.setStrPositiveTime(String.valueOf(lo.get(9))); 
            employee.setStrStatus(String.valueOf(lo.get(10))); 
            employee.setStrSeparationTime(String.valueOf(lo.get(11)));
            
            System.out.println("--------");
            System.out.println(employee.toString());
            
            
            try {
            	int add = employeeMapper.add(employee);				
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            
        }   
        return "文件导入成功！";
	
	}
	
	

}
