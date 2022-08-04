package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_project")
public class EmployeeProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate assignedFrom;
	
	@Column(nullable = false)
	private Integer hoursWorked;
	
	@OneToOne
	private Employee employee;
	
	@OneToOne
	private Project project;

	public EmployeeProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeProject(Long id, LocalDate assignedFrom, Integer hoursWorked, Employee employee, Project project) {
		super();
		this.id = id;
		this.assignedFrom = assignedFrom;
		this.hoursWorked = hoursWorked;
		this.employee = employee;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAssignedFrom() {
		return assignedFrom;
	}

	public void setAssignedFrom(LocalDate assignedFrom) {
		this.assignedFrom = assignedFrom;
	}

	public Integer getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(Integer hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "EmployeeProject [id=" + id + ", assignedFrom=" + assignedFrom + ", hoursWorked=" + hoursWorked
				+ ", employee=" + employee + ", project=" + project + "]";
	}
	
}
