package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.EmployeeFirstAndLast;
import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Employee> getAllEmployee() {	
		return empRepo.findAll();
	}

	@Override
	public Employee AddEmployeeDetails(Employee newEmployee) {
		return empRepo.save(newEmployee);
	}

	@Override
	public EmployeeFirstAndLast getFirstAndLast(Integer empid) {
		Optional<Employee> emp = empRepo.findById(empid);
		
		return mapper.map(emp, EmployeeFirstAndLast.class);
	}

	@Override
	public Employee updateEmpDetails(Employee updateEmp) {
		if(empRepo.existsById(updateEmp.getId())) {
			return empRepo.save(updateEmp);
		}
		throw new ResourceNotFoundException("Invaild Id...!!!");
	}

	@Override
	public String deleteEmployeeById(Integer empId) {
		String mesg ="Deletion Failed ..!!!!!";
		if(empRepo.existsById(empId))
		{
			empRepo.deleteById(empId);
			mesg = "Employee Deleted Successfully..!!!";
		}
		return mesg;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found...!!!"));
	}

	@Override
	public List<Employee> getEmpBySal(Double minSal, Double maxSal) {
		return empRepo.findBySalaryBetween(minSal, maxSal);
	}

	@Override
	public Employee authenticateEmployee(String email, String password) {
		
		return empRepo.findByEmailAndPassword(email, password);
	}
	
	

}
