package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.bean.Department;
import com.cg.ems.bean.Employee;
import com.cg.ems.bean.GradeMaster;
import com.cg.ems.bean.Users;
import com.cg.ems.service.DeptService;
import com.cg.ems.service.EmpService;
import com.cg.ems.service.GradeService;
import com.cg.ems.service.UsersService;

//public class EmployeeController {
	@RestController
	public class EmpController {

		@Autowired
		private EmpService eService;
		
		@Autowired
		private UsersService uservice;
		
		@Autowired
		private DeptService dservice;
		
		@RequestMapping("/admin")
		public String welcome(){
			return "index";
		}
		@RequestMapping(value="/admin1")
		public String login(Model model){
			model.addAttribute("admin",new Users());
			return "login";
		}

		
@RequestMapping("/login")
	public String login(Model model, String error, String logout) {
	
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)

			model.addAttribute("message", "You have been logged out successfully.");
		
		return "login";

}
	@RequestMapping("/adminLogin")
	public String getHome() throws Exception {
		int count = 1;
		if (count == 0) {
			Users users = new Users();
			users.setUserName("admin");
			users.setPassword("admin");
		
			Users register = uservice.recordsAdd(users);
			System.err.println(register);
			count++;
		}
		return "adLogin";
	}
		
		
		
		
		@RequestMapping(value="/addemployee",method= RequestMethod.POST)
		public Employee addEmployee(@RequestBody Employee employee)  {

			return eService.addEmp(employee);

		}

		
		
		@RequestMapping("/employee")    
		public List<Employee> getAllCustomers() throws Exception {
			return eService.getAllCustomers();
			}
		
		@RequestMapping(value="/employee/{empId}",method= RequestMethod.GET)
		public Employee getEmployeedetails(@PathVariable int empId) {
			return eService.getEmployee(empId);
		}
		
		@RequestMapping(value="/employeesearch/{empFirstName}",method= RequestMethod.GET)
		public List<Employee> getwildcard(@PathVariable String empFirstName) {
			return eService.getwildcard(empFirstName);
		}
		
		/*--------- Updating of Employee details based on Id------------ */

		
		@RequestMapping(value = "/employee/{empId}", method = RequestMethod.PUT)
		public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int empId) {
			return eService.updateEmployee(employee,empId);
		}
		

		/*-------- Deleting Employee record------------------- */

		@RequestMapping(value = "/deleteemployee/{empId}", method = RequestMethod.DELETE)
		public void deleteCustomerDetails(@PathVariable int empId) {
			eService.deleteEmployeeDetails(empId);

		}
		
		/**********************************************************************/
		
		@RequestMapping( value="/adddepartment",method= RequestMethod.POST)
		public Department adddepartment(@RequestBody Department department)  {
		
				return dservice.adddepartment(department);

			}
		
		@RequestMapping("/department")    
		public List<Department> getalldepartments() throws Exception {
			return dservice.getalldepartments();
			}
		
		
		/************************************************************************************************************/
		/***********************GRADEMASTER************************/
		
		@Autowired
		private GradeService gservice;
		
		@RequestMapping( value="/addgrade",method= RequestMethod.POST)
		public GradeMaster addgrade(@RequestBody GradeMaster grademaster)  {
		
				return gservice.addgrade(grademaster);

			}
		
		@RequestMapping("/grademaster")    
		public List<GradeMaster> getallgrades() throws Exception {
			return gservice.getallgrades();
			}
		
		
		@RequestMapping("/employees")
		public List<Employee> findBooks(@RequestParam(required = false) int empDeptId,

				@RequestParam(required = false) String empDesignation,

				@RequestParam(required = false) String empGradeCode) {
			return eService.get(empDeptId, empDesignation, empGradeCode);
		}
	}



