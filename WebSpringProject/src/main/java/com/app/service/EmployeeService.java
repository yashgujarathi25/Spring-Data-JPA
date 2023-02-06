package com.app.service;

import java.util.List;

import com.app.dto.EmployeeFirstAndLast;
import com.app.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee AddEmployeeDetails(Employee newEmployee);

	EmployeeFirstAndLast getFirstAndLast(Integer empid);
	
}