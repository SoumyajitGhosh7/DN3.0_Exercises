package com.employeeManagementSystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagementSystem.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	
	// Derived query method to find a department by its name
	Department findByName(String name);

    
}
