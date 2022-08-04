package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

@RestController
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@PostMapping("/project")
	public void insertProject(@RequestBody Project project) {
		projectRepository.save(project);
	}
}
