package com.everis.controller;

import com.everis.model.Course;
import com.everis.service.CourseService;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Courses")
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
   public Flux<Course> list() {
    return courseService.findAll();
  }

  /**
   * Method for Find By Id.
   */
  @GetMapping("{id}")
    public Mono<ResponseEntity<Course>> findById(@PathVariable String id) {
    return courseService.findById(id)
       .map(ResponseEntity::ok)
       .defaultIfEmpty(ResponseEntity.notFound()
       .build());
  }

  /**
   * Method for Create Course.
   */
  @PostMapping
   public Mono<ResponseEntity<Course>> createCourse(@RequestBody @Valid Course course) {
    Course courseToCrete = course.toBuilder().id(null).build();
    return courseService.create(courseToCrete).map(
        newCourse -> ResponseEntity.created(URI.create("/Courses/" + newCourse.getId()))
        .body(newCourse));
  }

  @PutMapping("{id}")
   public Mono<ResponseEntity<Course>> updateCourse(@PathVariable String id, 
      @RequestBody @Valid Course course) {
    return courseService.update(id, course).map(ResponseEntity::ok)
       .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("{id}")
   public Mono<ResponseEntity<Void>> deleteCourse(@PathVariable String id) {
    return courseService.deleteById(id).map(r -> ResponseEntity.ok().<Void>build())
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping("/searchByName/{name}")
   public Flux<Course> findByName(@PathVariable String name) {
    return courseService.findByName(name);
  }

  @GetMapping("/searchByDocument/{numberDocument}")
   public Flux<Course> findByStatus(@PathVariable String status) {
    return courseService.findByStatus(status);
  }

}
