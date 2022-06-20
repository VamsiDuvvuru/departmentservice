package com.test.DepartmentService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.test.DepartmentService.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
	Department save(Department department);
	
	Department findByDepartmentId(int departmentId);
	
	List<Department> findAll();

}
