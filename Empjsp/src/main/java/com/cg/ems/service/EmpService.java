package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.cg.ems.bean.Employee;
import com.cg.ems.repository.DeptRepository;
import com.cg.ems.repository.EmpRepository;
import com.cg.ems.repository.GradeRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository employeeRepository;
	
	@Autowired
	private DeptRepository deptRespo;
	
	@Autowired
	private GradeRepository gradrepo;


	
	/*public Employee addEmployee(Employee employee, int empDeptId) {

		employee.setDepartment(deptRespo.findOne(employee.getDepartment().getEmpDeptId()));
		
		return employeeRepository.save(employee);
	}*/

	public Employee getEmployee(int empId) {
		if (ValiadateEmpId(empId))
			return employeeRepository.getOne(empId);
		else
			return null;
	}

	private boolean ValiadateEmpId(int empId) {
		Employee employee = employeeRepository.findOne(empId);
		if (employee != null)
			return true;
		else
		return false;
	}

	public List<Employee> getAllCustomers() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	
	public Employee updateEmployee(Employee employee, int empId) {
		Employee beforeUpdate = (Employee) employeeRepository.getOne(empId);
		beforeUpdate.setEmpfName(employee.getEmpfName());
		beforeUpdate.setEmpAddress(employee.getEmpAddress());
		return employeeRepository.saveAndFlush(beforeUpdate);
	}

	

	public void deleteEmployeeDetails(int empId) {
		if (ValiadateEmpId(empId))
			employeeRepository.delete(empId);
	
		
	}

	public Employee addEmp(Employee employee) {
		//employee.setDepartment(deptRespo.findOne(employee.getDepartment().getEmpDeptId()));
		//employee.setGrademaster(gradrepo.findOne(employee.getGrademaster().getEmpGradeCode()));
		return employeeRepository.save(employee);
	}

	public List<Employee> get(int empDeptId, String empDesignation, String empGradeCode) {
		// TODO Auto-generated method stub
		return employeeRepository.findempdetails(deptRespo.findOne(empDeptId), empDesignation, gradrepo.findOne(empGradeCode));
	}

	public List<Employee> getwildcard(String empFirstName) {
		if (ValiadateEmpname(empFirstName))
			return employeeRepository.getDetails(empFirstName);
		else
			return null;
	}

	private boolean ValiadateEmpname(String empFirstName) {
		List<Employee> employee = employeeRepository.getDetails(empFirstName);
		if (employee != null)
			return true;
		else
		return false;
	}
	
}


