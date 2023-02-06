package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
