package com.kutay.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kutay.dto.DeveloperDTO;
import com.kutay.entity.Developer;
import com.kutay.repository.DeveloperRepository;

@Service
public class DeveloperService {

	@Autowired
	DeveloperRepository developerRepository;

	public List<DeveloperDTO> getAllDevelopers() {
		return developerRepository.findAll().stream().map(developerEntity -> {
			DeveloperDTO developerDTO = new DeveloperDTO();
			developerDTO.setId(developerEntity.getId());
			developerDTO.setName(developerEntity.getName());
			developerDTO.setKnownProgrammingLanguages(developerEntity.getKnownProgrammingLanguages());
			developerDTO.setEmploymentDate(developerEntity.getEmploymentDate());
			return developerDTO;
		}).collect(Collectors.toList());
	}

	public void createDeveloper(DeveloperDTO developerDTO) {
		Developer developerEntity = new Developer();
		developerEntity.setName(developerDTO.getName());
		developerEntity.setEmploymentDate(new Date());
		developerEntity.setKnownProgrammingLanguages(developerDTO.getKnownProgrammingLanguages());
		developerRepository.save(developerEntity);
	}

	public DeveloperDTO getDeveloperById(String developerId) {
		Optional<Developer> developerEntity = developerRepository.findById(developerId);
		DeveloperDTO developerDTO = new DeveloperDTO();
		developerEntity.ifPresent(entity -> {
			developerDTO.setEmploymentDate(entity.getEmploymentDate());
			developerDTO.setId(entity.getId());
			developerDTO.setKnownProgrammingLanguages(entity.getKnownProgrammingLanguages());
			developerDTO.setName(entity.getName());
		});

		return developerDTO;
	}

	public void addKnownProgrammingLanguage(String developerId, String knownProgrammingLanguage) {
		developerRepository.findById(developerId).ifPresent(developerEntity -> {
			developerEntity.getKnownProgrammingLanguages().add(knownProgrammingLanguage);
			developerRepository.save(developerEntity);
		});
	}

	public void deleteDeveloper(String developerId) {
		developerRepository.deleteById(developerId);
	}
}
