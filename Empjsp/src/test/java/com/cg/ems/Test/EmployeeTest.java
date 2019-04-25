package com.cg.ems.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.ems.bean.Department;
import com.cg.ems.bean.Employee;
import com.cg.ems.bean.GradeMaster;
import com.cg.ems.repository.DeptRepository;
import com.cg.ems.repository.EmpRepository;
import com.cg.ems.repository.GradeRepository;
import com.cg.ems.service.DeptService;
import com.cg.ems.service.EmpService;
import com.cg.ems.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {
	
	@InjectMocks
	private EmpService eService;
	@InjectMocks
	private DeptService dservice;
	@InjectMocks
	private GradeService gservice;

	@Mock
	private EmpRepository employeeRepository;

	@Mock
	private DeptRepository departmentRepository;
	
	@Mock
	private GradeRepository gradrepo;

	
	
	@Test
	public void addEmployeeTest() {
		Employee emp = new Employee();
		emp.setEmpId(100010);
		emp.setEmpfName("Swetha");
		emp.setEmplName("Thammuthaka");
		emp.setEmpDateOfBirth("29-09-1997");
		emp.setEmpDateOfJoining("23-3-2019");
		emp.setEmpDesignation("Developer");
		emp.setEmpBasic(15000);
		emp.setEmpGender("Female");
		emp.setEmpMartialStatus("Single");
		emp.setEmpAddress("Hyderabad");
		emp.setEmpContactNumber("95346824673");
		
		Department department = new Department();
		department.setEmpDeptId(100002);
		emp.setDepartment(department);
		when(departmentRepository.getOne(100002)).thenReturn(department);
		
		
		GradeMaster grademaster = new GradeMaster();
		 grademaster.setEmpGradeCode("M1");
		 emp.setGrademaster(grademaster);
		 when(gradrepo.getOne("M1")).thenReturn(grademaster);
		 when(employeeRepository.save(emp)).thenReturn(emp);
			
			Employee expectedEmployee = eService.addEmp(emp);
			System.out.println("**" + emp.toString());
			System.out.println("--" + expectedEmployee.toString());
			assertEquals(expectedEmployee, emp);
		
	}
	
	@Test
	public void adddepartmentTest() {
		Department department = new Department();
		department.setEmpDeptId(100101);
		department.setEmpDeptName("Java");
		when(departmentRepository.getOne(100101)).thenReturn(department);
		
		 when(departmentRepository.save(department)).thenReturn(department);
			
		 Department expectedEmployee = dservice.adddepartment(department);
			System.out.println("**" + department.toString());
			System.out.println("--" + expectedEmployee.toString());
			assertEquals(expectedEmployee, department);
		
	}
	
	@Test
	public void addgradeTest() {
		GradeMaster grademaster = new GradeMaster();
		grademaster.setEmpGradeCode("M1");
		grademaster.setEmpDescription("best");
		grademaster.setEmpMinSal(12000);
		grademaster.setEmpMaxSal(80000);
		
		 when(gradrepo.getOne("M1")).thenReturn(grademaster);
		
		 when(gradrepo.save(grademaster)).thenReturn(grademaster);
			
		 GradeMaster expectedEmployee = gservice.addgrade(grademaster);
			System.out.println("**" + grademaster.toString());
			System.out.println("--" + expectedEmployee.toString());
			assertEquals(expectedEmployee, grademaster);
	
	}
	
	
}
