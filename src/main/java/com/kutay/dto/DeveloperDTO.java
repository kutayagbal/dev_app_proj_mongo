package com.kutay.dto;

import java.util.Date;
import java.util.List;

public class DeveloperDTO {
	private String id;
	private String name;
	private List<String> knownProgrammingLanguages;
	private Date employmentDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getKnownProgrammingLanguages() {
		return knownProgrammingLanguages;
	}

	public void setKnownProgrammingLanguages(List<String> knownProgrammingLanguages) {
		this.knownProgrammingLanguages = knownProgrammingLanguages;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

}
