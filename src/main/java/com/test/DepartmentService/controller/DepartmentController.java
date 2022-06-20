package com.test.DepartmentService.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.DepartmentService.entity.Department;
import com.test.DepartmentService.entity.DepartmentUsers;
import com.test.DepartmentService.entity.PrincipalUser;
import com.test.DepartmentService.service.DepartmentInterface;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentInterface departmentService;
   
	
	@PostMapping("/")
	public String saveDepartmentData(@RequestBody Department department) {
		
		try {
			departmentService.saveDepartmentData(department);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "SUCCESS";
	}
	
	@GetMapping("/")
	public List<Department> getAllDepartmentDetails(){
		List<Department> departmentData=new ArrayList<>();		
		try {
			departmentData= departmentService.findALL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departmentData;		
	}
	
	
	@GetMapping("/{id}")
	public DepartmentUsers getAllDepartmentDetailsById(@PathVariable int id){
		Department department=new Department();
		DepartmentUsers users=new DepartmentUsers();
		System.out.println("caling get by id in department service");
		try {
			 department=departmentService.getById(id);
			 List<PrincipalUser> pusers=departmentService.callUserService();
			 for (PrincipalUser principalUser : pusers) {
				 if(department.getDepartmentId()==principalUser.getUserid()) {
					 users.setDepartment(department);
					 users.setUser(principalUser);
				 }
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
	
	
}
