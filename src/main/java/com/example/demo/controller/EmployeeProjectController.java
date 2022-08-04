package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeProject;
import com.example.demo.model.Project;
import com.example.demo.repository.EmployeeProjectRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;

@RestController
public class EmployeeProjectController {

	@Autowired
	private EmployeeProjectRepository employeeProjectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projecRepository;
	
	@PostMapping("/employee/project/{eid}/{pid}")
	public EmployeeProject insertEmployeeProject(@RequestBody EmployeeProject employeeProject,
										@PathVariable("eid") Long eid,
										@PathVariable("pid") Long pid) {
		Optional<Employee> optionalE = employeeRepository.findById(eid);
		if(!optionalE.isPresent())
			throw new RuntimeException("Invalid Employee id");
		Employee employee = optionalE.get();
		
		Optional<Project> optionalP = projecRepository.findById(pid);
		if(!optionalP.isPresent())
			throw new RuntimeException("Invalid Project Id");
		Project project = optionalP.get();
		
		employeeProject.setEmployee(employee);
		employeeProject.setProject(project);
		employeeProject.setAssignedFrom(LocalDate.now());
		
		return employeeProjectRepository.save(employeeProject);
		}
	@GetMapping("/employee/project/{pid}")
	public List<Employee> getEmployeeByProjectId(@PathVariable("pid") Long pid) {
		List<Employee> list=employeeProjectRepository.getEmployeeByProjectId(pid);
		return list;
	}
	@GetMapping("/project/employee/{eid}")
	public List<Project> getProjectByEmployeeId(@PathVariable("eid") Long eid) {
		List<Project> list = employeeProjectRepository.getProjectByEmployeeId(eid);
		return list;
	}
		
}
