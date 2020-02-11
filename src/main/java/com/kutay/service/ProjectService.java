package com.kutay.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kutay.dto.ApplicationDTO;
import com.kutay.dto.ProjectDTO;
import com.kutay.entity.Application;
import com.kutay.entity.Developer;
import com.kutay.entity.Project;
import com.kutay.repository.ApplicationRepository;
import com.kutay.repository.DeveloperRepository;
import com.kutay.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	DeveloperRepository developerRepository;

	public List<ProjectDTO> getAllProjects() {

		return projectRepository.findAll().stream().map(projectEntity -> {
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setApplications(projectEntity.getApplications().stream().map(applicationEntity -> {
				ApplicationDTO applicationDTO = new ApplicationDTO();
				applicationDTO.setId(applicationEntity.getId());
				applicationDTO.setName(applicationEntity.getName());
				applicationDTO.setProgrammingLanguage(applicationEntity.getProgrammingLanguage());
				return applicationDTO;
			}).collect(Collectors.toList()));

			projectDTO.setDesc(projectEntity.getDesc());
			projectDTO.setDevelopers(projectEntity.getDevelopers());
			projectDTO.setId(projectEntity.getId());
			projectDTO.setName(projectEntity.getName());
			return projectDTO;
		}).collect(Collectors.toList());
	}

	public void createProject(ProjectDTO projectDTO) {
		Project projectEntity = new Project();
		projectEntity.setDesc(projectDTO.getDesc());
		projectEntity.setDevelopers(projectDTO.getDevelopers());
		projectEntity.setName(projectDTO.getName());

		/*
		 * Check if there is an application for the given id. if there is one, add it's
		 * reference to project, if there is not, create a new application with the
		 * given name and add it's reference to project. Don't except if both id and
		 * name is empty.
		 */
		projectEntity.setApplications(projectDTO.getApplications().stream()
				.filter(applicationDTO -> !StringUtils.isEmpty(applicationDTO.getId())
						|| !StringUtils.isEmpty(applicationDTO.getName()))
				.map(applicationDTO -> {
					if (!StringUtils.isEmpty(applicationDTO.getId())) {
						return applicationRepository.findById(applicationDTO.getId())
								.orElseGet(() -> createApplicationUsingDTO(applicationDTO));
					} else {
						return createApplicationUsingDTO(applicationDTO);
					}
				}).collect(Collectors.toList()));

		projectRepository.save(projectEntity);
	}

	private Application createApplicationUsingDTO(ApplicationDTO applicationDTO) {
		Application applicationEntity = new Application();
		applicationEntity.setName(applicationDTO.getName());
		applicationEntity.setProgrammingLanguage(applicationDTO.getProgrammingLanguage());
		return applicationRepository.save(applicationEntity);
	}

	public void addApplicationsToProject(String projectId, List<String> applicationIds) {
		projectRepository.findById(projectId).ifPresent(projectEntity -> {
			((List<Application>) applicationRepository.findAllById(applicationIds)).stream()
					.forEach(applicationEntity -> {
						projectEntity.getApplications().add(applicationEntity);
					});

			projectRepository.save(projectEntity);
		});
	}

	public void addDevelopersToProject(String projectId, List<String> developerIds) {
		projectRepository.findById(projectId).ifPresent(projectEntity -> {
			((List<Developer>) developerRepository.findAllById(developerIds)).stream().forEach(developerEntity -> {
				projectEntity.getDevelopers().add(developerEntity.getName());
			});

			projectRepository.save(projectEntity);
		});
	}

	public void removeDevelopersFromProject(String projectId, List<String> developerIds) {
		projectRepository.findById(projectId).ifPresent(projectEntity -> {
			List<String> developerNames = ((List<Developer>) developerRepository.findAllById(developerIds)).stream()
					.map(Developer::getName).collect(Collectors.toList());

			projectEntity.getDevelopers().removeAll(developerNames);
			projectRepository.save(projectEntity);
		});
	}

	public void removeApplicationsFromProject(String projectId, List<String> applicationIds) {
		projectRepository.findById(projectId).ifPresent(projectEntity -> {
			projectEntity.getApplications()
					.removeIf(applicationEntity -> applicationIds.contains(applicationEntity.getId()));
			projectRepository.save(projectEntity);
		});
	}

	public void deleteProject(String projectId) {
		projectRepository.deleteById(projectId);

	}

}
