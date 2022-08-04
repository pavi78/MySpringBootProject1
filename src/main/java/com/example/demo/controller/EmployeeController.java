package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/employee/{did}")
	public Employee insertEmployee(@RequestBody Employee employee,
								@PathVariable("did") Long did) {
		Optional<Department> optionalD = departmentRepository.findById(did);
		if(!optionalD.isPresent())
			throw new RuntimeException("Invalid department id");
		Department department = optionalD.get();
		
		employee.setDepartment(department);
		
		return employeeRepository.save(employee);
				
	}
	@GetMapping("/employee/{dname}")
	public List<Employee> getEmployeeByDepartmentName(@PathVariable("dname") String dname) {
		List<Employee> list = employeeRepository.getEmployeeByDepartmentName(dname);
		return list;
	}
}
