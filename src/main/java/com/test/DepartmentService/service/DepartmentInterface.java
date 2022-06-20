package com.test.DepartmentService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.DepartmentService.entity.Department;
import com.test.DepartmentService.entity.PrincipalUser;

@Service
public interface DepartmentInterface {
	
	public void saveDepartmentData(Department department) throws Exception;
	
	public List<Department> findALL() throws Exception;
	
	public Department getById(int id) throws Exception; 
	
	public List<PrincipalUser> callUserService() throws Exception;

}
