package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeProject;
import com.example.demo.model.Project;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

	@Query("select ep.employee from EmployeeProject ep where ep.project.id=?1")
	List<Employee> getEmployeeByProjectId(Long pid);

	@Query("select ep.project from EmployeeProject ep where ep.employee.id=?1")
	List<Project> getProjectByEmployeeId(Long eid);

	
	

}
