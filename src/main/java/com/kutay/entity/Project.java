package com.kutay.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Project {

	@Id
	private String id;
	private String name;
	private String desc;

	/*
	 * This was put as an example of denormalization, embededed documents should be
	 * used for NoSQL DBs
	 */
	private List<String> developers;

	/*
	 * This was put as an example of relations, embededed documents should be used
	 * for NoSQL DBs. https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mapping-chapter
	 */
	@DBRef(lazy = true)
	private List<Application> applications;

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

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
