package com.kutay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kutay.dto.ApplicationDTO;
import com.kutay.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	ApplicationService applicationService;

	@PutMapping
	public void createApplication(@RequestBody ApplicationDTO applicationDTO) {
		applicationService.createApplication(applicationDTO);
	}

	@DeleteMapping
	public void createApplication(@RequestParam String applicationId) {
		applicationService.deleteApplication(applicationId);
		/*
		 * Should be removed from related project. No problem because this is not a
		 * regular action.
		 */
	}

}
