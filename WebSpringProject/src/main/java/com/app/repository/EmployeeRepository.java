package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findBySalaryBetween(Double minSal, double maxSal);
	
	Employee findByEmailAndPassword(String email, String password);
}
