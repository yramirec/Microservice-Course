package com.everis.repository;

import com.everis.model.Course;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {

  Flux<Course> findByName(String name);
  
  Flux<Course> findByStatus(String idStatus);

}
