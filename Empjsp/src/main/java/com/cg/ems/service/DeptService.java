package com.cg.ems.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.bean.Department;
import com.cg.ems.repository.DeptRepository;

@Service
public class DeptService {
	@Autowired
	private DeptRepository departmentRepository;

	public Department adddepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	public List<Department> getalldepartments() {
		
		return departmentRepository.findAll();
	}
}
