package com.kutay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kutay.dto.ApplicationDTO;
import com.kutay.entity.Application;
import com.kutay.repository.ApplicationRepository;

@Service
public class ApplicationService {
	@Autowired
	ApplicationRepository applicationRepository;

	public void createApplication(ApplicationDTO applicationDTO) {
		Application applicationEntity = new Application();
		applicationEntity.setName(applicationDTO.getName());
		applicationEntity.setProgrammingLanguage(applicationDTO.getProgrammingLanguage());
		applicationRepository.save(applicationEntity);
	}

	public void deleteApplication(String applicationId) {
		applicationRepository.deleteById(applicationId);
	}

}
