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

import com.kutay.dto.DeveloperDTO;
import com.kutay.service.DeveloperService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

	@Autowired
	DeveloperService developerService;

	@GetMapping("/list")
	public List<DeveloperDTO> getAllDevelopers() {
		return developerService.getAllDevelopers();
	}

	@PutMapping
	public void createDeveloper(@RequestBody DeveloperDTO developerDTO) {
		developerService.createDeveloper(developerDTO);
	}

	@GetMapping("/get")
	public DeveloperDTO getDeveloperById(@RequestParam String developerId) {
		return developerService.getDeveloperById(developerId);
	}

	@PostMapping("/addlanguage")
	public void addKnownProgrammingLanguage(@RequestParam String developerId,
			@RequestParam String knownProgrammingLanguage) {
		developerService.addKnownProgrammingLanguage(developerId, knownProgrammingLanguage);
	}

	@DeleteMapping
	public void deleteDeveloper(@RequestParam String developerId) {
		developerService.deleteDeveloper(developerId);
		/*
		 * Should be removed from related projects. No problem because this is not a
		 * regular action.
		 */
	}
}
