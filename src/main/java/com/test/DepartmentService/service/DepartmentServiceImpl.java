package com.test.DepartmentService.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.DepartmentService.entity.Department;
import com.test.DepartmentService.entity.PrincipalUser;
import com.test.DepartmentService.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentInterface{
	
	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void saveDepartmentData(Department department) {
		// TODO Auto-generated method stub
		
		repo.save(department);
	}

	@Override
	public List<Department> findALL() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub
		return repo.findByDepartmentId(id);
	}

	@Override
	public List<PrincipalUser> callUserService() throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<List<PrincipalUser>> users=restTemplate.exchange("http://USERSERVICE/users/",HttpMethod.GET ,null,new ParameterizedTypeReference<List<PrincipalUser>>() {});;
		System.out.println("get all users");
		List<PrincipalUser> principalUsers=users.getBody();	
		return principalUsers;
		
	}

}
