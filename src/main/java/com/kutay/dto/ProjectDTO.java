package com.kutay.dto;

import java.util.List;

public class ProjectDTO {

	private String id;
	private String name;
	private String desc;
	private List<String> developers;
	private List<ApplicationDTO> applications;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}

	public List<ApplicationDTO> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationDTO> applications) {
		this.applications = applications;
	}

}
