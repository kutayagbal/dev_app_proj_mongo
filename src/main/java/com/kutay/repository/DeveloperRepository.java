package com.kutay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kutay.entity.Developer;

public interface DeveloperRepository extends MongoRepository<Developer, String>{

}
