package com.kutay.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Developer {

	@Id
	public String id;
	public String name;
	public List<String> knownProgrammingLanguages;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date employmentDate;

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
