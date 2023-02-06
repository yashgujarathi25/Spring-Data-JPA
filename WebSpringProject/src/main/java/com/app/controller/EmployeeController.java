package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entity.Employee;
import com.app.service.EmployeeService;

import io.swagger.v3.oas.models.security.SecurityScheme.In;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empSer;
	
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return empSer.getAllEmployee();
	}
	
	@PostMapping("/add")
	public Employee addNewEmployee(@RequestBody Employee newEmployee) {
		return empSer.AddEmployeeDetails(newEmployee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee updateEmp) {
		return empSer.updateEmpDetails(updateEmp);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ApiResponse deleteEmployee(@PathVariable Integer empId) {
		return new ApiResponse(empSer.deleteEmployeeById(empId));
	}
	
	@PostMapping("/{empid}")
	public ResponseEntity<?> getFirstAndLastName(@PathVariable Integer empid){
		return ResponseEntity.ok(empSer.getFirstAndLast(empid));
	}
	
	@GetMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		return empSer.getEmployeeById(empId);
	}
}
