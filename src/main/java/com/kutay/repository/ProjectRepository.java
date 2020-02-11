package com.kutay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kutay.entity.Project;

public interface ProjectRepository  extends MongoRepository<Project, String>{

}
