package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e where e.department.name=?1")
	List<Employee> getEmployeeByDepartmentName(String dname); 
		
}
