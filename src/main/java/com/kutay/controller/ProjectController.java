package com.kutay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kutay.dto.ProjectDTO;
import com.kutay.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping("/list")
	public List<ProjectDTO> getAllProjects() {
		return projectService.getAllProjects();
	}

	@PutMapping
	public void createProject(@RequestBody ProjectDTO projectDTO) {
		projectService.createProject(projectDTO);
	}

	@PostMapping("/addapplications")
	public void addApplicationsToProject(@RequestParam String projectId, @RequestBody List<String> applicationIds) {
		projectService.addApplicationsToProject(projectId, applicationIds);
	}

	@PostMapping("/adddevelopers")
	public void addDevelopersToProject(@RequestParam String projectId, @RequestBody List<String> developerIds) {
		projectService.addDevelopersToProject(projectId, developerIds);
	}

	@PostMapping("/removedevelopers")
	public void romoveDevelopersFromProject(@RequestParam String projectId, @RequestBody List<String> developerIds) {
		projectService.removeDevelopersFromProject(projectId, developerIds);
	}

	@PostMapping("/removeapplications")
	public void removeApplicationsFromProject(@RequestParam String projectId,
			@RequestBody List<String> applicationIds) {
		projectService.removeApplicationsFromProject(projectId, applicationIds);
	}

	@DeleteMapping
	public void deleteProject(@RequestParam String projectId) {
		projectService.deleteProject(projectId);
	}
}
