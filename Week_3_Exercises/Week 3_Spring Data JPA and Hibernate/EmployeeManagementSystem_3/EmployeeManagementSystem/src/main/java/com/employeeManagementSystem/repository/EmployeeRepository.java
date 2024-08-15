package com.employeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagementSystem.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
    // Derived query method to find employees by their name	
	 List<Employee> findByName(String name);

}
