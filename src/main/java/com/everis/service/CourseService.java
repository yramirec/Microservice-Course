package com.everis.service;

import com.everis.model.Course;

import com.everis.repository.CourseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class CourseService {

  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Mono<Course> create(Course course) {
    return courseRepository.save(course);
  }

  public Mono<Course> findById(String id) {
    return courseRepository.findById(id);
  }

  public Flux<Course> findAll() {
    return courseRepository.findAll();
  }

  /**
   * Method for Update Course By Id.
   */
  public Mono<Course> update(String id, Course updateCourse) {
    return courseRepository.findById(id)
        .map(existingCourse -> existingCourse.toBuilder()
        .idTeacher(updateCourse.getIdTeacher())
        .students(updateCourse.getStudents())
        .idStatus(updateCourse.getIdStatus())
        .build())
        .flatMap(courseRepository::save);
  }


  public Mono<Course> deleteById(String id) {
    return courseRepository.findById(id)
        .flatMap(course -> courseRepository.delete(course).then(Mono.just(course)));
  }

  public Flux<Course> findByName(String name) {
    return courseRepository.findByName(name);
  }

  public Flux<Course> findByStatus(String idStatus) {
    return courseRepository.findByStatus(idStatus);
  }

}
