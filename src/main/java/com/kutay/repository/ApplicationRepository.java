package com.kutay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kutay.entity.Application;

public interface ApplicationRepository extends MongoRepository<Application, String> {

}
